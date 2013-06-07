angular.module('meetingMoodAppServices', [])
    .factory('MeetingManager', function() {
        var url = "ws://172.23.4.155:8084/meetingmood/jamessocket";
        return {
            init : function() {
                var self = this;
                this.connection = new WebSocket(url);

                /*this.connection.onopen = function() {
                    console.log("connected");
                }*/
                this.connection.onclose = function() {
                    console.log("onclose");
                }
                this.connection.onerror = function (error) {
                    console.log(error);
                }
                this.connection.onmessage = function(event) {
                    console.log("refresh");
                    var data = angular.fromJson(event.data);
                    self.refresh(data);
                }
				
            },
			
			connect : function(meetingId, name) {
                this.sendMessage({
                    method : "register",
                    params : {
						meetingId : meetingId,
						name : name
					}
                });
			},
            
            getContext : function() {
                this.sendMessage({
                    method : "getContext",
                    params : {}
                });
            },
            
            addComment : function(comment, name) {
                this.sendMessage({
                    method : "addComment",
                    params : {
						username : name,
						comment : comment
                    }
                });
            },
            
            updateMood : function(mood) {
                this.sendMessage({
                    method : "updateMood",
                    params : {
                        newMood : mood
                    }
                });
            },
			
            updateNeed : function(need) {
                this.sendMessage({
                    method : "updateNeed",
                    params : {
                        need : need
                    }
                });
            },
            
            sendMessage : function(event) {
				try
				  {
					this.connection.send(JSON.stringify(event));
				  }
				catch(err)
				  {
					window.alert(err);
				  }
				
            }
        }
    });
