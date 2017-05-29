$(function(){
  var config = {
    apiKey: "AIzaSyCsplac_ewTCGM0U6uhR54dl5AoXs5M7LA",
    authDomain: "ratelistapp.firebaseapp.com",
    databaseURL: "https://ratelistapp.firebaseio.com",
    projectId: "ratelistapp",
    storageBucket: "ratelistapp.appspot.com",
    messagingSenderId: "1045430833895"
  };
  firebase.initializeApp(config);

  var username;
  var password;
  $('#form').submit(function(event) {
      event.preventDefault();
      // $(this).submit();
  });

  $("#loginButton").click(function(){
    var loading = "<img id='loading' src='../images/loading.gif'>";
    $("#error").html(loading);
    username = $("#username").val();
    password = $("#password").val();

    var x = firebase.database().ref().child("admins").once('value').then(function(snapshot) {
      // e.preventDefault();/
      var admins = snapshot.val();
      var adminFound = false;
      console.log(username);
      console.log(password);
      for (var i=1;  i<admins.length;i++ ){
        if(username == admins[i].username){
          if(password == admins[i].password){
            window.location.replace("pages/adminHome.html");
            adminFound = true;
          }
        }
      }
      if(adminFound == false){
        $("#error").text("Wrong username/password entered");
      }
    });
  });

});
