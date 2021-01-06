document.addEventListener('DOMContentLoaded',function(){



  document.querySelector("#stepsScroll").addEventListener("click", function() {
    document.querySelector(".steps").scrollIntoView();
  })

  document.querySelector("#aboutScroll").addEventListener("click", function ()
  {
    document.querySelector(".about-us").scrollIntoView();
  });

  document.querySelector("#helpScroll").addEventListener("click",function (){
    document.querySelector(".help").scrollIntoView();
  })

  document.querySelector("#contactScroll").addEventListener("click", function() {
    document.querySelector(".contact").scrollIntoView();
  })

})