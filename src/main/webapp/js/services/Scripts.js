function randomStr(m) {
	var m = m || 9; 
	var s = '';
	var r = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	
	for (var i=0; i < m; i++) { s += r.charAt(Math.floor(Math.random()*r.length)); }
	return s;
};

function generateImgUrl(mood, need, forecast, meetingMood) {
	
	var url = "img/action_btn/";
	
	if (meetingMood != '')
	{
		if (meetingMood == "green")
			url += "james_green.png";
		else if (meetingMood == "yellow")
			url += "james_yellow.png";
		else if (meetingMood == "red")
			url += "james_red.png";
		else
			url += "james_green.png";
	}
	
	if (mood != '')
	{
		if (mood == "green")
			url += "action_btn_green.png";
		else if (mood == "yellow")
			url += "action_btn_yellow.png";
		else if (mood == "orange")
			url += "action_btn_orange.png";
		else if (mood == "red")
			url += "action_btn_red.png";
		else
			url += "action_btn_grey.png";
	}
	
	if (need != '')
	{
		if (need == "break")
			url += "action_btn_break.png";
		else if (need == "food")
			url += "action_btn_food.png";
		else if (need == "wc")
			url += "action_btn_wc.png";
		else if (need == "angry")
			url += "action_btn_angry.png";
		else
		{
			url += "action_btn_noneed.png";
		}
	}
	
	if (forecast != '')
	{
		if (forecast == "down")
			url += "trend_down.png";
		else if (forecast == "neutral")
			url += "trend_neutral.png";
		else if (forecast == "up")
			url += "trend_up.png";
		else
			url += "trend_neutral.png";
	}
	
	return url;
};

function setCookie(c_name,value,exdays)
{
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
	document.cookie=c_name + "=" + c_value;
}

function getCookie(c_name)
{
	var c_value = document.cookie;
	var c_start = c_value.indexOf(" " + c_name + "=");
	if (c_start == -1)
	  {
	  c_start = c_value.indexOf(c_name + "=");
	  }
	if (c_start == -1)
	  {
	  c_value = null;
	  }
	else
	  {
	  c_start = c_value.indexOf("=", c_start) + 1;
	  var c_end = c_value.indexOf(";", c_start);
	  if (c_end == -1)
	  {
	c_end = c_value.length;
	}
	c_value = unescape(c_value.substring(c_start,c_end));
	}
	return c_value;
}

function printDate() {
    var temp = new Date();
    var dateStr = temp.getDate().toString() + "." +
				  temp.getMonth().toString() + "." + 
				  temp.getFullYear().toString() + " " +
                  temp.getHours().toString() + ":" +
                  temp.getMinutes().toString();

    return dateStr ;
}