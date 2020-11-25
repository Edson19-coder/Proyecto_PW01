$(document).ready(function () {
     $('.table tbody').on('click', '#ascend', function () {
        var currow = $(this).closest('tr');
        var col = currow.find('#id').text();
        var col2 = currow.find('#ut').text();
        var accs = "ascend";
         $.post('InspectUsers',{
             idu: col,
             acc: accs,
             ut: col2
         }, function(responseText){
             $('#tabla').html(responseText);
         });
    });
    
    $('.table tbody').on('click', '#descend', function () {
        var currow = $(this).closest('tr');
        var col = currow.find('#id').text();
        var col2 = currow.find('#ut').text();
        var accs = "descend";
         $.post('InspectUsers',{
             idu: col,
             acc: accs,
             ut: col2
         }, function(responseText){
             $('#tabla').html(responseText);
         });
    });
});




