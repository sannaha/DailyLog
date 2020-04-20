<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改记录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="https://dailylog.sannaha.moe/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="https://dailylog.sannaha.moe/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">


</head>
<body>
<div class="container">
    <center><h3>修改记录</h3></center>
    <form action="update" method="post">
        <div class="form-group">
            <label for="d_date" class="col-md-1 control-label">日期</label>
            <!--设置一个隐藏域，保存联系id-->
            <input type="hidden" name="id" value="${dailyLog.id}">
            <div class="input-group date form_date col-md-3" data-date="" data-date-format="yyyy-MM-dd"
                 data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                <input class="form-control" size="16" type="text" name="d_date" value="${dailyLog.d_date}" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
            <input type="hidden" id="d_date" value=""/><br/>
        </div>

        <div class="form-group">
            <label for="t_waketime" class="col-md-1 control-label">起床时间</label>
            <div class="input-group date form_time col-md-3" data-date="" data-date-format="yyyy-MM-dd hh:ii"
                 data-link-field="dtp_input3" data-link-format="hh:ii">
                <input class="form-control" size="16" type="text" name="t_waketime" value="${dailyLog.t_waketime}" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
            </div>
            <input type="hidden" id="t_waketime" value=""/><br/>
        </div>

        <div class="form-group">
            <label for="t_bedtime" class="col-md-1 control-label">上床时间</label>
            <div class="input-group date form_time col-md-3" data-date="" data-date-format="yyyy-MM-dd hh:ii"
                 data-link-field="dtp_input3" data-link-format="hh:ii">
                <input class="form-control" size="16" type="text" name="t_bedtime" value="${dailyLog.t_bedtime}" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
            </div>
            <input type="hidden" id="t_bedtime" value=""/><br/>
        </div>

        <div class="form-group">
            <label for="vc_improvetime">学习(h)：</label>
            <select name="vc_improvetime" class="form-control" id="vc_improvetime">
                <option value="0" <c:if test="${dailyLog.vc_improvetime == '0'}">selected="selected"</c:if>>0小时</option>
                <option value="1" <c:if test="${dailyLog.vc_improvetime == '1'}">selected="selected"</c:if>>1小时</option>
                <option value="2" <c:if test="${dailyLog.vc_improvetime == '2'}">selected="selected"</c:if>>2小时</option>
                <option value="3" <c:if test="${dailyLog.vc_improvetime == '3'}">selected="selected"</c:if>>3小时</option>
                <option value="4" <c:if test="${dailyLog.vc_improvetime == '4'}">selected="selected"</c:if>>4小时</option>
                <option value="5" <c:if test="${dailyLog.vc_improvetime == '5'}">selected="selected"</c:if>>5小时</option>
                <option value="6" <c:if test="${dailyLog.vc_improvetime == '6'}">selected="selected"</c:if>>6小时</option>
                <option value="7" <c:if test="${dailyLog.vc_improvetime == '7'}">selected="selected"</c:if>>7小时</option>
                <option value="8" <c:if test="${dailyLog.vc_improvetime == '8'}">selected="selected"</c:if>>8小时</option>
            </select>
        </div>

        <div class="form-group">
            <label for="vc_improve">学习详情：</label>
            <input type="text" class="form-control" id="vc_improve" name="vc_improve" value="${dailyLog.vc_improve}" placeholder="请罗列学习内容">
        </div>

        <div class="form-group">
            <label for="vc_fishingtime">摸鱼(h)：</label>
            <select name="vc_fishingtime" class="form-control" id="vc_fishingtime">
                <option value="0" <c:if test="${dailyLog.vc_fishingtime == '0'}">selected="selected"</c:if>>0小时</option>
                <option value="1" <c:if test="${dailyLog.vc_fishingtime == '1'}">selected="selected"</c:if>>1小时</option>
                <option value="2" <c:if test="${dailyLog.vc_fishingtime == '2'}">selected="selected"</c:if>>2小时</option>
                <option value="3" <c:if test="${dailyLog.vc_fishingtime == '3'}">selected="selected"</c:if>>3小时</option>
                <option value="4" <c:if test="${dailyLog.vc_fishingtime == '4'}">selected="selected"</c:if>>4小时</option>
                <option value="5" <c:if test="${dailyLog.vc_fishingtime == '5'}">selected="selected"</c:if>>5小时</option>
                <option value="6" <c:if test="${dailyLog.vc_fishingtime == '6'}">selected="selected"</c:if>>6小时</option>
                <option value="7" <c:if test="${dailyLog.vc_fishingtime == '7'}">selected="selected"</c:if>>7小时</option>
                <option value="8" <c:if test="${dailyLog.vc_fishingtime == '8'}">selected="selected"</c:if>>8小时</option>
            </select>
        </div>

        <div class="form-group">
            <label for="vc_fishing">摸鱼详情：</label>
            <input type="text" class="form-control" id="vc_fishing" name="vc_fishing" value="${dailyLog.vc_fishing}" placeholder="请罗列摸鱼内容"/>
        </div>

        <div class="form-group">
            <label for="vc_eurekatime">尤里卡(h)：</label>
            <select name="vc_eurekatime" class="form-control" id="vc_eurekatime">
                <option value="0" <c:if test="${dailyLog.vc_eurekatime == '0'}">selected="selected"</c:if>>0小时</option>
                <option value="1" <c:if test="${dailyLog.vc_eurekatime == '1'}">selected="selected"</c:if>>1小时</option>
                <option value="2" <c:if test="${dailyLog.vc_eurekatime == '2'}">selected="selected"</c:if>>2小时</option>
                <option value="3" <c:if test="${dailyLog.vc_eurekatime == '3'}">selected="selected"</c:if>>3小时</option>
                <option value="4" <c:if test="${dailyLog.vc_eurekatime == '4'}">selected="selected"</c:if>>4小时</option>
                <option value="5" <c:if test="${dailyLog.vc_eurekatime == '5'}">selected="selected"</c:if>>5小时</option>
                <option value="6" <c:if test="${dailyLog.vc_eurekatime == '6'}">selected="selected"</c:if>>6小时</option>
                <option value="7" <c:if test="${dailyLog.vc_eurekatime == '7'}">selected="selected"</c:if>>7小时</option>
                <option value="8" <c:if test="${dailyLog.vc_eurekatime == '8'}">selected="selected"</c:if>>8小时</option>
            </select>
        </div>

        <div class="form-group">
            <label for="vc_eureka">尤里卡详情：</label>
            <input type="text" class="form-control" id="vc_eureka" name="vc_eureka" value="${dailyLog.vc_eureka}" placeholder="请罗列尤里卡内容"/>
        </div>

        <div class="form-group">
            <label for="vc_activitytime">活动(h)：</label>
            <select name="vc_activitytime" class="form-control" id="vc_activitytime">
                <option value="0" <c:if test="${dailyLog.vc_activitytime == '0'}">selected="selected"</c:if>>0小时</option>
                <option value="1" <c:if test="${dailyLog.vc_activitytime == '1'}">selected="selected"</c:if>>1小时</option>
                <option value="2" <c:if test="${dailyLog.vc_activitytime == '2'}">selected="selected"</c:if>>2小时</option>
                <option value="3" <c:if test="${dailyLog.vc_activitytime == '3'}">selected="selected"</c:if>>3小时</option>
                <option value="4" <c:if test="${dailyLog.vc_activitytime == '4'}">selected="selected"</c:if>>4小时</option>
                <option value="5" <c:if test="${dailyLog.vc_activitytime == '5'}">selected="selected"</c:if>>5小时</option>
                <option value="6" <c:if test="${dailyLog.vc_activitytime == '6'}">selected="selected"</c:if>>6小时</option>
            </select>
        </div>

        <div class="form-group">
            <label for="vc_activity">活动详情：</label>
            <input type="text" class="form-control" id="vc_activity" name="vc_activity" value="${dailyLog.vc_activity}" placeholder="请罗列活动内容"/>
        </div>

        <div class="form-group">
            <label for="vc_remark">备注：</label>
            <input type="text" class="form-control" id="vc_remark" name="vc_remark" value="${dailyLog.vc_remark}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" onclick="javascript:history.back(-1);" value="返回"/>
        </div>
    </form>
</div>

<!-- 2. jQuery导入，建议使用1.9以上的版本 -->
<script type="text/javascript" src="https://dailylog.sannaha.moe/js/jquery-1.11.3.js" charset="UTF-8"></script>
<!-- 3. 导入bootstrap的js文件 -->
<script type="text/javascript" src="https://dailylog.sannaha.moe/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://dailylog.sannaha.moe/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="https://dailylog.sannaha.moe/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>

</body>
</html>