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
  var loading = "../images/loading.gif";
  var complaintsHtml = "<img id='loading' src="+loading+">";
  var mainComplaints = $("#viewComplaints");
  mainComplaints.html(complaintsHtml);
  x = firebase.database().ref().child("complaints").once('value').then(function(snapshot) {
    // e.preventDefault();/
    var complaints = snapshot.val();
    var allComplaintsHtml = "";
    console.log(complaints[1].username);
    for (var i=1;  i<complaints.length;i++ ){
      allComplaintsHtml += "<div class='complaint";
      if(i == complaints.length-1){
        allComplaintsHtml+="-last'";
      }
      allComplaintsHtml+="'>"+
      "<p><h4>Name: </h4>"+complaints[i].username+"</p>"+
      "<p><h4>Shop name: </h4>"+complaints[i].shopname+"</p>"+
      "<p><h4>Complaint: </h4>"+complaints[i].complaint+"</p>"+
      "</div>";
    }
    mainComplaints.html(allComplaintsHtml);
  });

});
