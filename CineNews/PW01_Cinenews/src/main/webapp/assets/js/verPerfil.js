$(document).ready(function(){
   $("#VerMiPerfil").on('click', function(){
       $.get('Porfile', {accion : 'MyPorfile'}, function(responseText){
          location.href ="/Porfile";
       });
   });
});


