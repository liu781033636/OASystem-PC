
$(document).ready(function() {

		window.setInterval(function(){ shuaxin()}, "10000");
	
	//$("#ddd").click(function (){
	// 直接把onclick事件写在了JS中
	function shuaxin() {
		params="values="+$("#meg").val(); 
		$.ajax( {
			type : "POST",
			url : "persons/Rasmessage1/rasmessage_checkFanhui.action",
			data : params,
			dataType:"JSON",
			success : function(data){
				data = eval("(" + data + ")");
				if("1"==data.meString.replace(/^\s*/, "").replace(/\s*$/, "")){
					$("#tip").html("");
					
				}
				else if("0"==data.meString.replace(/^\s*/, "").replace(/\s*$/, "")){
					
					$("#tip")
					.css("color", "#ff6600")
					.html("<img  src='images/pic/unchecked.gif' class='img_align'></img> " + "您有新消息");
				}
			}
		});
		

	}


	

	
});