jQuery(document).ready(function($) {

	$('#msg').html("This is updated by jQuery")

});


//double click pour effacer le text 
$("p").dblclick(function(){
    $(this).hide();
  });

// action avec le passage de la souris ouvre un popup 
//  $("#carre").mouseenter(function(){
//    alert("tu entres sur le carré un popoup qui fait chié :p !");
//  });

// action avec le passage de la souris quand on sort de la div 
//  $("#carre").mouseleave(function(){
//    alert("quand tu sort du carré un popoup qui fait chié :p !");
//  });

//$("#carre").mousedown(function(){
//    alert("Souris qui est dans le div action qui ouvre un popup au click");
//  });

//$("#carre").mouseup(function(){
//    alert("Popup qui apparait au relachement du click !! sur l'iD");
//  });

//change la couleur du focus 
//$("input").focus(function(){
//    $(this).css("background-color", "blue");
//  });

//le remet en blanc
$("input").blur(function(){
    $(this).css("background-color", "#ffffff");
  });

  //quand on est sur le focus ça met le fond en gris 
  $("p").on({
    mouseenter: function(){
      $(this).css("background-color", "lightgray");
    },
    // ça le change de couleur quand on le quitte et met en bleu 
    mouseleave: function(){
      $(this).css("background-color", "lightblue");
    },
    // et quand on est en clique dessus ça faait en jaune 
    click: function(){
      $(this).css("background-color", "yellow");
    }
  }); 
// cache et reaffiche 
  //$(".button").click(function(){
    //$("p").toggle();
  //}); 

  //$(".button").click(function(){
    //$("div").animate({left: '250px'});
  //});

  //$(".button").click(function(){
   // $("div").animate({
     // height: 'toggle'
   // });
  //});  

$(".button").click(function(){
    $("div").css("color", "red")
    .slideUp(4000)
    .slideDown(4000); 
   });