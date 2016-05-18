var ChangePassword = function () {
    
    return {
        //main function to initiate the module
        init: function () {
	        $('.change-password-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                password: {
	                    required: true
	                },
	                rpassword: {
	                    equalTo: "#register_password"
	                },
	            },
	            messages: {
	                password: {
	                    required: "密码不能为空."
	                },
	                rpassword: {
	                	equalTo: "请输入相同的密码"
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
	            submitHandler: function (form) {
	            	$(form).ajaxSubmit();
	            }
	        });
	        jQuery('#register-back-btn').click(function () {
	        	window.location.href = "/login";
	        });
        }
    };
}();