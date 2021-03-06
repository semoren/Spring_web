var Register = function () {
    
    return {
        //main function to initiate the module
        init: function () {
	        $('.register-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                username: {
	                    required: true
	                },
	                password: {
	                    required: true
	                },
	                email: {
	                    required: true,
	                    email: true
	                }
	            },
	            messages: {
	            	username: {
	            		required: "昵称不能为空"
	            	},
	                email: {
	                    required: "登陆邮箱不能为空."
	                },
	                password: {
	                    required: "密码不能为空."
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