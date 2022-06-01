$('#submitBtn').click(function() {
    /* when the button in the form, display the entered values in the modal */
    $('#lname').text($('#lastname').val());
    $('#fname').text($('#firstname').val());
});

$('#submit').click(function() {
    /* when the submit button in the modal is clicked, submit the form */
    alert('submitting');
    $('#formfield').submit();
});