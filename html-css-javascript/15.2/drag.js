var drag = function(target, event)
{
    var startX = event.clientX;
    var startY = event.clientY;
    var origX = target.offsetLeft;
    var origY = target.offsetTop;
    var deltaX = startX - origX;
    var deltaY = startY - origY;
    target.setCapture();
    var moveHandler = function()
    {
        var evt = window.event;
        target.style.left = (evt.clientX - deltaX) + "px";
        target.style.top = (evt.clientY = deltaY) + "px";
        evt.cancelBubble = true;
    }
    var upHandler = function()
    {
        var evt = window.event;
        target.detachEvent("onlosecapture", upHandler);
        target.detachEvent("onmouseup", upHandler);
        target.detachEvent("onmousemove", moveHandler);
        target.releaseCapture();
        evt.cancelBubble = true;
    }
    target.attachEvent("onmousemove", moveHandler);
    target.attachEvent("onmouseup", upHandler);
    target.attachEvent("onlosecapture", upHandler);
    event.cancelBubble = true;
    event.returnValue = false;
}