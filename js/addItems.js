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

  var viewItems = $(".currentItems");
  var allItemsHtml = "<img id='loading' src='../images/loading.gif'>";
  viewItems.html(allItemsHtml);
  var allItems = {};

  function updateTable(){
    x = firebase.database().ref().child("items").once('value').then(function(snapshot) {
      // e.preventDefault();/
      var items = snapshot.val();
      var allItemsHtml = "";
      allItemsHtml +="<table>"+
      "<tr>"+
      "<td><h4>ID</h4></td>";
      allItemsHtml +=
      "<td><h4>Name</h4></td>";
      allItemsHtml +=
      "<td><h4>Rate</h4></td>"+
      "</tr>";
      for (var i=1;  i<items.length;i++ ){
        allItemsHtml+="<tr>"+
        "<td>"+items[i].id+"</td>"+
        "<td>"+items[i].name+"</td>"+
        "<td>"+items[i].rate+"</td>"+
        "</tr>";
      }
      allItemsHtml+="</table>";
      viewItems.html(allItemsHtml);
      allItems = items;
    });
  }

  updateTable();

  $("#addItemButton").click(function(){
    // var newPostKey = firebase.database().ref().child('items').push().key;

    var userid = $("#id").val();
    var username = $("#name").val();
    var userprice = $("#price").val();
    var len = (allItems.length).toString();
    var addItems = {};
    if(userid.length>0 && username.length>0 && userprice>0){
      console.log(typeof(len));
      allItems[len] ={

        id: userid,
        name: username,
        rate: userprice

      };
      // console.log(addItems);
      var itemsRef = firebase.database().ref().child('items');
      itemsRef.set(
        allItems
      );

      updateTable();
    }

  });

  $("#deleteItemButton").click(function(){
    // var newPostKey = firebase.database().ref().child('items').push().key;

    var userid = $("#id").val();
    var username = $("#name").val();
    var userprice = $("#price").val();
    var len = (allItems.length).toString();
    if(userid.length>0){
      for(var i=1; i<allItems.length; i++){
        if(allItems[i].id == userid){
          delete allItems[i];
          break;
        }
      }

      console.log(allItems);
      // console.log(addItems);
      var itemsRef = firebase.database().ref().child('items');
      itemsRef.set(
        allItems
      );

      updateTable();
    }

  });

  $("#modifyItemButton").click(function(){
    // var newPostKey = firebase.database().ref().child('items').push().key;

    var userid = $("#id").val();
    var username = $("#name").val();
    var userprice = $("#price").val();
    var len = (allItems.length).toString();
    if(userid.length>0){
      for(var i=1; i<allItems.length; i++){
        if(allItems[i].id == userid){
          allItems[i].id == userid;
          allItems[i].name = username;
          allItems[i].rate = userprice;
          break;
        }
      }

      // console.log(allItems);
      // console.log(addItems);
      var itemsRef = firebase.database().ref().child('items');
      itemsRef.set(
        allItems
      );

      updateTable();
    }

  });

});
