'use strict';

angular.module('JamesAppServices', [])
	.factory('WebSocket', function() {
		return {
			connect : function(url) {
				var self = this;
				this.connection = new WebSocket(url);

				this.connection.onopen = function() {
					if (this.onopen) {
						self.onopen();
					}
				}
				this.connection.onclose = function() {
					if (this.onclose) {
						self.onclose();
					}
				}
				this.connection.onerror = function (error) {
					if (this.onerror) {
						self.onerror(error);
					}
				}
				this.connection.onmessage = function(event) {
					if (this.onmessage) {
						self.onmessage(event);
					}
				}
			},
			
			send : function(message) {
				this.connection.send(message);
			},
			
			close : function() {
				this.connection.onclose = function () {}; // disable onclose handler first
				this.connection.close()
			}
		}
	});