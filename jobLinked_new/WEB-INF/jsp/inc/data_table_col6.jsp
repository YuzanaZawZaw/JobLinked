<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
</head>
<body>
	<!-- for data table -->
	<!-- <script src="/js/jquery.js"></script> -->
	<script
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
	<!-- <script
		src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.jshttps://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"></script> -->
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-3-typeahead/4.0.2/bootstrap3-typeahead.js"></script>	
	<script>
	$(document).ready(function () {
		 var dataSrc = [];
    	$('#myTable').DataTable({
    	        pagingType: 'full_numbers',
    	        scrollY: true,
    	        "lengthMenu": [5, 10, 25, 50, 75, 100],
    	        'initComplete': function(){
    	            var api = this.api();
    	            api.cells('tr', [0,1,2,3,4,5]).every(function(){
    	                // Get cell data as plain text
    	                var data = $('<div>').html(this.data()).text();           
    	                if(dataSrc.indexOf(data) === -1){ dataSrc.push(data); }
    	             });
    	         	// Sort dataset alphabetically
    	            dataSrc.sort();
    	           
    	            // Initialize Typeahead plug-in
    	            $('.dataTables_filter input[type="search"]', api.table().container())
    	               .typeahead({
    	                  source: dataSrc,
    	                  afterSelect: function(value){
    	                     api.search(value).draw();
    	                  }
    	               }
    	            );
				}
    	  });
    	}
	);
	</script>
</body>
</html>