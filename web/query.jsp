<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="jquery/jquery-1.11.3.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        function confirmDel(param) {
            if (window.confirm("您确定要删除该条记录吗？")) {
                document.location = "delete?id=" + param
            }
        }
    </script>

    <style>
        tr th {
            text-align: center;
            background-color: #e3e3e3;
        }
    </style>
    <style type="text/css">
        .ellipsis {
            overflow: hidden; /*自动隐藏文字*/
            text-overflow: ellipsis;/*文字隐藏后添加省略号*/
            white-space: nowrap;/*强制不换行*/
            width: 14em;/*不允许出现半汉字截断*/
        }
    </style>
</head>
<body>

<table class="table table-bordered table-hover">
    <caption>
        <h1>
            <center>摸鱼日记</center>
        </h1>
    </caption>
    <tr class="text-center">
        <td colspan="14" align="center">
            <a class="btn btn-primary" href="add.jsp">添加</a>
        </td>
    </tr>
    <%--表头--%>
    <tr class="text-center">
        <th hidden>id</th>
        <th>日期</th>
        <th>起床时间</th>
        <th>睡觉时间</th>
        <th>学习(h)</th>
        <th>学习详情</th>
        <th>摸鱼(h)</th>
        <th>摸鱼详情</th>
        <th>尤里卡(h)</th>
        <th>尤里卡详情</th>
        <th>运动(h)</th>
        <th>运动详情</th>
        <th>得分</th>
        <th>备注</th>
        <th></th>
    </tr>
    <%--
        <c:forEach item=${list}   var="dailylog" >
            <tr>一条记录  每个td是记录的属性值
        <c:forEach>
    --%>
    <c:forEach items="${list}" var="dailylog">
        <tr class="text-center">
            <td hidden>${dailylog.id}</td>
            <td>${dailylog.d_date}</td>
            <td>${dailylog.t_waketime}</td>
            <td>${dailylog.t_bedtime}</td>
            <td>${dailylog.vc_improvetime}</td>
            <td><div class="ellipsis" title="${dailylog.vc_improve}">${dailylog.vc_improve}</div></td>
            <td>${dailylog.vc_fishingtime}</td>
            <td><div class="ellipsis" title="${dailylog.vc_fishing}">${dailylog.vc_fishing}</div></td>
            <td>${dailylog.vc_eurekatime}</td>
            <td><div class="ellipsis" title="${dailylog.vc_eureka}">${dailylog.vc_eureka}</div></td>
            <td>${dailylog.vc_activitytime}</td>
            <td><div class="ellipsis" title="${dailylog.vc_activity}">${dailylog.vc_activity}</div></td>
            <td>${dailylog.vc_point}</td>
            <td><div class="ellipsis" title="${dailylog.vc_remark}">${dailylog.vc_remark}</div></td>
            <td>
                <a class="btn btn-danger" onclick="confirmDel(${dailylog.id})">删除</a>
                <a href="queryById?id=${dailylog.id}" class="btn btn-primary">修改</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
