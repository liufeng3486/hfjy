jQuery.fn.extend(
		uploadFile : function(s) {
		var file = $(this);	
		file.off("change");
		file.on("change", function() {
			file.off("change");
			$.ajaxFileUpload({
				url : 'upload',
				secureuri : false,
				fileElementId : file.attr("id"),
				dataType : 'json',
				success : function(data, status) {
					if (s.success) {
						s.success(data);
					}
				},
				error : function(data, status, e) {
					if (s.error) {
						s.error();
					}
				}
			});
		});

		file.click();
	}
});
