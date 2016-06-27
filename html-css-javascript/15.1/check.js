String.prototype.trim = function()
{
    return this.replace(/^s*/, "").replace(/\s*$/, "");
}
var check = function()
{
    var form = document.forms[0];
    var errStr = "";
    if(form.user.value == null
    || form.user.value.trim() == "")
    {
        errStr += "\nuser cannot be empty!";
        form.user.focus();
    }
    if(form.pass.value == null
    || form.pass.value.trim() == "")
    {
        errStr += "\npass cannot be empty!";
        form.pass.focus();
    }
    if(form.email.value == null
    || form.email.value.trim() == "")
    {
        errStr += "\nemail cannot be empty!";
        form.pass.focus();
    }
    if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(form.email.value.trim()))
    {
        errStr += "\nemail incorrect!";
        form.email.focus();
    }
    if(errStr != "")
    {
        alert(errStr);
        return false;
    }
}