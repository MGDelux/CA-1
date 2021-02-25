   
        let boys = new Array("Peter", "lars", "Ole");
        let girls = new Array("Janne", "hanne", "Sanne");
        let all = boys.concat(girls);
        
        
    function AddBoy() {
            let y = document.getElementById("text_boy").value;
            boys.push(y);
            for(i = 0; i < boys.length; i++ ){
            console.log(boys[i]);
            let HTML = "<li>" + boys[i] + "</li>";             
            document.getElementById("Boys_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
            
        };
       

        function AddGirl() {
         let y = document.getElementById("text_girl").value;
            girls.push(y);
            for(i = 0; i < girls.length; i++ ){
            console.log(girls[i]);
            let HTML = "<li>" + girls[i] + "</li>";             
            document.getElementById("Girls_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
        function clearBoxBoys() { 
            var div = document.getElementById("Boys_row"); 
              
            while(div.firstChild) { 
                div.removeChild(div.firstChild); 
            } 
        } 
        function clearBoxGirls() { 
            var div = document.getElementById("Girls_row"); 
              
            while(div.firstChild) { 
                div.removeChild(div.firstChild); 
            } 
        } 
        function clearBoxAll() { 
            var div = document.getElementById("All_row"); 
              
            while(div.firstChild) { 
                div.removeChild(div.firstChild); 
            } 
        } 

    function RemoveBoy() {
    if(document.getElementById("Remove_first").checked){
     boys.shift();
    }if(document.getElementById("Remove_last").checked){
      boys.pop();
    }
    clearBoxBoys("Boys_row");
     for(i = 0; i < boys.length; i++ ){
            console.log(boys[i]);
            let HTML = "<li>" + boys[i] + "</li>";             
            document.getElementById("Boys_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
      function RemoveGirl() {
    if(document.getElementById("Remove_first").checked){
     girls.shift();
    }if(document.getElementById("Remove_last").checked){
      girls.pop();
    }
    clearBoxGirls("Girls_row");
     for(i = 0; i < girls.length; i++ ){
            console.log(girls[i]);
            let HTML = "<li>" + girls[i] + "</li>";             
            document.getElementById("Girls_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
    function ReverseAll(){
    boys.splice(0,boys.length);
    girls.splice(0,girls.length);
    
    }
    
    function SortAll(){
        let all = boys.concat(girls).sort((a,b) => a.toLowerCase().localeCompare(b.toLowerCase()));
       
    clearBoxAll("All_row");
     for(i = 0; i < all.length; i++ ){
            console.log(all[i]);
            let HTML = "<li>" + all[i] + "</li>";             
            document.getElementById("All_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
    function onLoad(){
        for(i = 0; i < boys.length; i++ ){
            console.log(boys[i]);
            let HTML = "<li>" + boys[i] + "</li>";             
            document.getElementById("Boys_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
         for(i = 0; i < girls.length; i++ ){
            console.log(girls[i]);
            let HTML = "<li>" + girls[i] + "</li>";             
            document.getElementById("Girls_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
        for(i = 0; i < all.length; i++ ){
            console.log(all[i]);
            let HTML = "<li>" + all[i] + "</li>";             
            document.getElementById("All_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }