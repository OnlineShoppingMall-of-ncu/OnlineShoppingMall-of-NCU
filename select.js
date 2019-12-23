var province=$(".province"),city=$(".city"),county=$(".county");
for(var i=0;i<provinceList.length;i++){
    addEle(province,provinceList[i].province);
}
function addEle(ele,value){
    var optionStr="";
    optionStr="<option value="+value+">"+value+"</option>";
    ele.append(optionStr);
}
function removeEle(ele){
    ele.find("option").remove();
    var optionStar="<option value="+"请选择"+">"+"请选择"+"</option>";
    ele.append(optionStar);
}
var provinceText,cityText,cityItem;
province.on("change",function(){
    provinceText=$(this).val();
    $.each(provinceList,function(i,item){
        if(provinceText == item.province){
            cityItem=i;
            return cityItem
        }
    });
    removeEle(city);
    removeEle(county);
    $.each(provinceList[cityItem].city,function(i,item){
        addEle(city,item.name)
    })
});
city.on("change",function(){
    cityText=$(this).val();
    removeEle(county);
    $.each(provinceList,function(i,item){
        if(provinceText == item.name){
            cityItem=i;
            return cityItem
        }
    });
    $.each(provinceList[cityItem].city,function(i,item){
        if(cityText == item.name){
            for(var n=0;n<item.county.length;n++){
                addEle(county,item.county[n])
            }
        }
    });
});