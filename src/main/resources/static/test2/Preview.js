imgFile.addEventListener('change',function(){
//	console.log(this.files);
    //获取选定的图片的数量
    var Picnumber = this.files.length;
    //若不等于0，则说明新选了图片，所以要清除div里面的所有元素
    if(Picnumber != 0){
        $("#preview").empty();
    }

    for(var i = 0; i<Picnumber; i++ ){
        let file = this.files[i];
        //判断是否图片类型
        if(!/image\/\w+/.test(file.type)){
            alert("看清楚，这个需要图片！");
            return false;
        }
        let PicSrc = URL.createObjectURL(file);

        Pic_str = '<div id="Preview_'+i+'" class="Preview_box">';
        Pic_str +='<a class="DelTag" οnclick="DelTag('+"'Preview_"+i+"'"+')">删除</a>';
        Pic_str +='<img src="'+PicSrc+'"/>';
        Pic_str +='</div>';

        $("#preview").append(Pic_str);
    }
});
//删除对应图片
function DelTag(val){
    $("#"+val).remove();
}

