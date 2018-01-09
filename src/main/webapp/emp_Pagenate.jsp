<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8">
    <title>分頁測試</title>
	<style>
		/* CSS */
	</style>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/spring_mvc/resources/css/tableStyle.css" />
  </head>
  <body>
      
    每頁筆數：<input type="text" name="perNum" style="font-size:20px;text-align:center;width:100px;" value="3"/>
    <button id='setPageBtn'>設定</button>
    <br/><br/>
      
	<table id='myTable' border="1">
	  <thead>
		  <tr>
		    <th>empNo</th>
		    <th>empName</th>
		    <th>empJob</th> 
		    <th>empHireDate</th>
		  </tr>
	  </thead>
	  <tbody>
	  
      </tbody>
	</table>
      
      <br/><br/>
      <div class="pagination">
      	<!-- 分頁頁碼 -->
	  </div>
  </body>
  
  
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
  	$(function(){ 
  		
  		calc_totalPages( $('input[name="perNum"]').val() ); // 計算總頁數
  		
  		$('div[class=pagination]').on('click','a',function(){
  			
  			var aTags = $('div[class=pagination] a');
  			$.each( aTags , function(){
  				$(this).removeClass('active');
  			});
  			$(this).addClass('active'); // 當前選中的 a標籤
  			
  			var myTbody_tr = $('#myTable>tbody tr');
  			myTbody_tr.remove(); // 移除tbody 下的所有 <tr>
  			//-----------------------------------------------------------
  			var perNum = parseInt( $('input[name="perNum"]').val(), 10); // 每頁顯示筆數
  			var pageCode = parseInt( $(this).text(), 10); // 選中的頁碼
  			
  			var n1$ = ( pageCode-1 ) * perNum + 1;
  			var n2$ = n1$ + perNum - 1;
  			
  			$.get('<%=request.getContextPath()%>/spring_mvc/empCRUD/getEmpsByRowNum'
  			      ,{ n1: n1$ , n2: n2$ } // 送到Server的Data
  			      , function(cbData){
  			    	    var documentFragment = $(document.createDocumentFragment());
		  			    $.each(cbData , function(ind){ 
		  			    	console.log( $(this) );
		  			    	$('<tr></tr>').append( $('<td></td>').text(cbData[ind].empNo)) 
		  			    				  .append( $('<td></td>').text(cbData[ind].empName))
		  			    				  .append( $('<td></td>').text(cbData[ind].empJob))
		  			    				  .append( $('<td></td>').text(cbData[ind].empHireDate))
		  			    	.appendTo(documentFragment);
		  			    });
		  			    documentFragment.appendTo( $('#myTable>tbody') );
  			      }
		  	);
  		}); 
  		
  		
  		$('#setPageBtn').click(function(){
  			var divTag = $('div[class="pagination"]'); 
  			divTag.children().remove(); // 移除舊的分頁標籤
  			calc_totalPages( $('input[name="perNum"]').val() ); // 計算總頁數
  		});
  		
  	});
  </script>
  
  <script type="text/javascript">
  	function calc_totalPages( _pageSize ){
  		$.get('<%=request.getContextPath()%>/spring_mvc/empCRUD/getAllEmps?isEager=false'
				, function(data){ 
					var totalRecord = data.length;
					var pageSize = parseInt( _pageSize , 10); // 每頁顯示筆數
					var totalPageNum = ( totalRecord  +  pageSize  - 1) / pageSize;  // 總頁數
					console.log('totalPageNum', parseInt( totalPageNum , 10) );
					//--------------------------------------------------------------
					var divTag = $('div[class="pagination"]'); 
					divTag.append( $('<a href="#">&laquo;</a>') );
					for(var i = 0 ; i < parseInt( totalPageNum , 10) ; i++ ){
						divTag.append( $('<a href="javascript:void(0)">' + (i+1) + '</a>') );
					}
					divTag.append( $('<a href="#">&raquo;</a>') );
				}
		);
  	}
  </script>
</html>
