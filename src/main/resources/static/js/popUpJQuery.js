// function to launch form popUp
function FormPopUpExcel(title, content) {

	// 2 params : title and content
	/**
	 * Example --> title: New Policy Content: '<form action=""
	 * class="formName">' + '<div class="form-group">' + '<label>Enter
	 * something here</label>' + '<input type="text" placeholder="Your name"
	 * class="name form-control" required />' + '</div>' + '</form>',
	 * 
	 */
	$.confirm({
		title : title,
		content : content,
		buttons : {
			formSubmit : {
				text : 'Submit',
				btnClass : 'btn-blue',
				action : function() {
					
					//if (verifyEmptyFields("FormNewPolicy")) {
					showLoading();

						document.getElementById('FormUploadFile').submit();

					/*} else {
						errorPopUp("Empty Fields",
								"All the fields must be populated");
					}*/
				}
			},
			cancel : function() {
				// close
			},
		},
		onContentReady : function() {
			// bind to events
			var jc = this;
			this.$content.find('form').on('submit', function(e) {
				// if the user submits the form by pressing enter in the field.
				e.preventDefault();
				jc.$$formSubmit.trigger('click'); // reference the button and
													// click it
			});
		}
	});
}
