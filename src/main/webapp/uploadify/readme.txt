主要文件：

jquery.uploadify.js(完成上传功能的脚本文件，在调用页面引用)、

uploadify.css(外观样式表)

uploader.swf(上传控件的主体文件，flash控件)

upload.php(服务器端处理文件，官方仅提供了php版的)


uploadify3.1不显示取消按钮uploadify-cancel.png路径都是对的，什么情况

css 文件中找到这个图片换成你的路径。同一目录下这样写： background: url('uploadify-cancel.png') 0 0 no-repeat;


