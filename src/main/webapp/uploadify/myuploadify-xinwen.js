

var strPath=window.document.location.pathname;
var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);

// <!--ready事件-->
 	$(document).ready(function() {
		$("#uploadFile").uploadify({
			'debug' : false,
			'width' : '50',
			'height' : '20',
			'swf' :  postPath +'/uploadify/uploadify.swf',//上传的flash
			'cancelImg' : 'uploadify/uploadify-cancel.png',//取消的X
			 'uploader'      : '${pageContext.request.contextPath}/xinWenAction!fileUpload',//后台处理的请求
			'method' : 'POST',
			'fileSizeLimit' : 2048,  //设置单个文件大小限制，这是2M
			'simUploadLimit' : 1,//每次最大上传文件数
			'queueSizeLimit' :1,//每次可浏览的最大文件数
			'fileObjName' : 'uploadFile',//和input的name属性值保持一致就好，Struts2就能处理了
			'auto' : true,//是否选取文件后自动上传
			'multi' : false,//是否支持多文件上传
			'displayData' : 'speed',//有speed和percentage两种，一个显示速度，一个显示完成百分比
		
			'fileTypeExts': '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式
			'fileTypeDesc': '支持格式:jpg/gif/jpeg/png/bmp', //如果配置了以下的'fileExt'属性，那么这个属性是必须的  
			
			'queueID' : 'fileQueue',// 文件队列ID。与div的id一致
		    'buttonText' : '浏 览',//button上的文字
		    
		    'onComplete' : function (event, queueID, fileObj, response, data){
	        $("#result").html(response);//显示上传成功结果
	        setInterval("showResult()",500);//2000 =两秒后删除显示的上传成功结果
	        }
		});
	});
	
	 function showResult(){//删除显示的上传成功结果
         $("#result").html("");
       }
       function uploadFile(){//上传文件
        jQuery('#uploadFile').uploadify('upload' , '*');
       }
       function clearFile(){//清空所有上传队列
        jQuery('#uploadFile').uploadify('cancel' , '*');
       } 