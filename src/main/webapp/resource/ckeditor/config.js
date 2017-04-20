/*
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	 config.language = 'zh-cn'; // 配置语言  
	 //config.uiColor = '#FFF'; // 背景颜色  
	//config.width = 800;  // 宽度  
	config.height =140;  // 高度  
	config.skin = 'kama';
	config.toolbar = 'Full';
	
	config.toolbar_Full = [

['Cut','Copy','Paste','PasteText','PasteFromWord','-', 'SpellChecker', 'Scayt'],
['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
'/',
['NumberedList','-','Outdent','Indent'],
['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
['Styles','Format','Font','FontSize']
];
	
};
