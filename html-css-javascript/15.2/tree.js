var clickHandler = function()
{
    var targetId;
    var targetElement;
    var srcElement = event.srcElement;
    if(srcElement.className.substr(0, 7)) == "outline")
    {
        if(srcElement.id.indexOf("Image")) > 0)
        {
            targetId = srcElement.id.substring(0, srcElement.id.length - 5) + "Details";
        }
        else
        {
            targetId = srcElement.id + "Details";
        }
        targetElement = document.getElementById(targetId);
        if(targetElement)
        {
            if(targetElement.style.display == "none")
            {
                targetElement.style.display = "";
            }
            else
            {
                targetElement.style.display = "none";
            }
        }
        if(srcElement.id.indexOf("Image") > 0)
        {
            targetId = srcElement.id;
        }
        else
        {
            targetId = srcElement.id + "Image";
        }
        targetElement = document.getElementById(targetId);
        if(targetElement.src.indexOf("plus") >= 0)
        {
            targetElement.src = "image/minus.gif";
        }
        else
        {
            targetElement.src = "image/plus.gif";
        }
    }
}
document.onclick = clickHandler;