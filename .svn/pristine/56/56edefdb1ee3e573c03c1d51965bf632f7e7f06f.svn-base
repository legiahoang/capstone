function Slider(){
  var settings = {
    primeiraImg: function() {
      var el = document.querySelector('#slider a:first-child');
      el.classList.add('ativo');
      settings.legenda(el);
    },   
  
    slide: function() {
      var el = document.querySelector('.ativo');
      
      if(el.nextElementSibling) {
        el.nextElementSibling.classList.add('ativo');
        settings.legenda(el.nextElementSibling);
        el.classList.remove('ativo'); 
      } else {
        el.classList.remove('ativo');
        settings.primeiraImg();
      }   
    },
    
    proximo: function() {
      clearInterval(intervalo);
      var el = document.querySelector('.ativo');
      
      if(el.nextElementSibling) {
        el.nextElementSibling.classList.add('ativo');
        settings.legenda(el.nextElementSibling);
        el.classList.remove('ativo'); 
      } else {
        el.classList.remove('ativo');
        settings.primeiraImg();
      }
      intervalo = setInterval(settings.slide, 5000);
    },
    
    anterior: function() {
      clearInterval(intervalo);
      var el = document.querySelector('.ativo');
      
      if(el.previousElementSibling) {
        el.previousElementSibling.classList.add('ativo');
        settings.legenda(el.previousElementSibling);
        el.classList.remove('ativo');
      } else {
        el.classList.remove('ativo');
        el = document.querySelector('#slider  a:last-child');
        el.classList.add('ativo');
        settings.legenda(el);
      }
      intervalo = setInterval(settings.slide, 5000);
    },

    legenda: function(selector) { 
      var legenda = selector.querySelector('img').getAttribute('alt');
      document.querySelector('figcaption').innerHTML = legenda;
    },     
  }
  
  //chama a função
  settings.primeiraImg();
  
  //roda
  var intervalo = setInterval(settings.slide, 5000);
  document.querySelector('.next').addEventListener('click', settings.proximo, false);
  document.querySelector('.prev').addEventListener('click', settings.anterior, false);
}

window.addEventListener('load', Slider, false);