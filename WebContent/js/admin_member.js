$(function() {
	$("#search").keyup(function() {
		var txt = $(this).val().toUpperCase();
		$('#tbody tr').filter(function() {
			$(this).toggle($(this).text().toUpperCase().indexOf(txt) > -1);
		});

	});
	$.ajax({
		url : "/Funshop/admin.do",
		data : {
			search : $("#search").val()
		},
		success : function(result) {
			$("div").html(result);
		}
	}); // ajax
}); // document ready
