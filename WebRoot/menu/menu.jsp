<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>menu</title>

<!--     <link rel="stylesheet" type="text/css" href="../css/lanrentuku.css" /> -->

    <script type="text/javascript" src="../js/jquery-1.4.js"></script>
<!--     <script type="text/javascript" src="../js/jquery.easing.1.3.js"></script> -->
    <script type="text/javascript" src="../js/xixi.js"></script>
    <style type="text/css">
body{
/* 	background-image:url(../images/menu_bg2.jpg); */
	background-color:#c0c0c0;
	background-repeat:no-repeat;
	margin:0;
	padding:0;
}
body, td, th {
	font-size: 18px;
	color: #FFF;
}
body{
	/* Setting default text color, background and a font stack */
	font-family:"微软雅黑",Arial, Helvetica, sans-serif;
	font-size:18px;
	padding:0;
	margin:0;
	background-color:#cococo;
	background-repeat:no-repeat;
}

ul{
	margin:0;
	padding:0;
}
li{
	list-style:none;
	text-align:left;
	width:150px;
	margin:10;
	
}

.dropdown{
	/* The expandable lists */
	display:none;
	padding-top:5px;
	width:150px;
/* 	background-color: #5c5c5c; */
/* 	font-color:#000000; */
	color: #FFF;
}
.dropdown li{
	width:100px;
	background-color:#456789;
	padding:4px 18px;
	margin:0 0 0 18px;
	border:1px solid #40392c;
	color: #FFFFFF;
}
li.menu{
	/* The main list elements */
	padding:5px 0;
	width:100%;
	
}

li.button a{
	/* The section titles */
	display:block;
	font-family:  "微软雅黑",BPreplay,Arial,Helvetica,sans-serif;
	font-size:21px;
	height:25px;
	overflow:hidden;
	padding:5px  5px;
	position:relative;
	width:140px;
	background-color: #D6D6D6;
	margin-left:5px;
}


li.dropdown ul li{
	margin-left:11px;
	margin-right:5px;
	padding-right:18px;
	color: #FFFFFF;
}

 a:visited {
	color: #FFFFFF;
	text-decoration:none;
	outline:none;
}
 a {
	
	text-decoration:none;
	outline:none;
}

a:hover{
	text-decoration:underline;
}

div{
	margin:0px;
	padding:5px;
}
</style>
  </head>
  
  <body style="margin:0px">
    <table width="100%">
      <div style="margin:0px">
        ${menuString }

        <div class="clear"></div>
      </div>
    </table>
  </body>
</html>