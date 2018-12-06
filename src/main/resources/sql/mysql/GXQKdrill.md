首页高校情况党政单位钻取
===
    select distinct a.单位号,a.单位名称,a.单位负责人 from 学校单位信息 a where a.单位类别='党政单位'

首页高校情况教学单位钻取
===
    select distinct a.单位号,a.单位名称,a.单位负责人 from 学校单位信息 a where a.单位类别='教学单位'

首页高校情况重点学科钻取
===
    select a.学科代码,a.重点学科名称,a.级别 from 重点学科 a

首页高校情况在校生数钻取
===
    select a.`普通本科学生数`,a.`硕士研究生数全日制`,a.`博士研究生数全日制`,a.`留学生数` from 学生数量基本情况 a

首页高校情况教职工总数专业技术职称钻取
===
    select count(distinct a.工号) 人数,a.专业技术职称 from 教职工基本信息 a group by a.专业技术职称

首页高校情况教职工总数最高学位钻取
===
    select count(distinct a.工号) 人数,a.最高学位 from 教职工基本信息 a group by a.最高学位

首页高校情况总占地面积钻取
===
    select a.占地总面积,a.占地面积学校产权,a.学校产权绿化用地,a.学校产权运动场地,a.占地非学校产权,
    a.非学校产权独立使用,a.非学校产权共同使用,a.非学校产权绿化用地 from 占地与建筑面积 a