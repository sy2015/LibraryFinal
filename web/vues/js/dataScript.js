var autocompleteInput = function (field) {
   $.ajax({
        url : "http://localhost:8080/Library_Final/vues/getData.action",
        type : "GET",
        success : function(data) {
            if(data){
                data = JSON.parse(data);
                var books = [];
                data.forEach(function(item){
                    books.push(item.bookName);
                });
               
                 
                  $( "#"+field ).autocomplete({
                    source: books
                  });
            }
        }
    }); 
};
$(document).ready(autocompleteInput("book1"));