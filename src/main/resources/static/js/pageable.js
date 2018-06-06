$(document).ready(function() {
	var page = 1;
	$("#showMore").click(function(){
			//Hide button and show spinner
	        $(this).hide();
	        $('#loading').html('<img src="images/spinner.gif" width="80px" height="80px"/>');		
	        //Data upload
			$.ajax({
				url: ('showMore/'+page),
				dataType: 'html',
				success: function(html) {
					$('#entrees').append(html);
					$(this).hide();
					page++;
				}
			});
			//Show button and hide spinner
			$(this).show();
			$('#loading').hide(); 
	 });
	
});