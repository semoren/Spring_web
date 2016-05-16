var Forget = function () {
    
    return {
        //main function to initiate the module
        init: function () {
	        $('.forget-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                email: {
	                    required: true,
	                    email: true
	                }
	            },
	            messages: {
	                email: {
	                    required: "邮箱不能为空."
	                }
	            },
	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },
	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },
	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },
	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },
	            submitHandler: function (form) {
	                $(form).ajaxSubmit();
	            }
	        });
	        $('.forget-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.forget-form').validate().form()) {
	                    $(form).ajaxSubmit();
	                }
	                return false;
	            }
	        });
	        jQuery('#back-btn').click(function () {
	        	window.location.href = "/login";
	        });
        }
    };
}();