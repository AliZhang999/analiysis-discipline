首页师资情况教职工数对标
===
    select a.学校名称,count(b.工号) 学校值
    from 教职工基本信息 b left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页师资情况实验师资对标
===
    select a.学校名称,count(case when b.是否实验技术人员='是' then 1 else null end) 学校值
    from 在编教职工 b left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页师资情况高层次人才对标
===
    select a.学校名称,count(distinct b.工号) 学校值
    from 高层次人才 b left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页师资情况教授上台讲课比例对标
===
    select a.学校名称,a.上课教授数/b.教授总数*100 学校值 from (
      select c.学校名称,count(distinct b.工号) 上课教授数
      from 开课情况 a
      left join 教职工基本信息 b on a.授课教师工号=b.工号
      left join 学校基本信息 c on c.学校代码=b.学校代码
      where b.专业技术职称='教授' and c.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
      group by a.学校代码
    ) a left join (
      select a.学校名称,count(distinct b.工号) 教授总数
      from 教职工基本信息 b
      left join 学校基本信息 a on a.学校代码=b.学校代码
      where b.专业技术职称='教授' and b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
      group by a.学校代码
    ) b on a.学校名称=b.学校名称 order by 学校值 desc

首页师资情况专任教师对标2016
===
    select a.学校名称,count(distinct b.工号) 学校值
    from 在编教职工 b
    left join 教职工基本信息 c on b.工号=c.工号 and b.学校代码=c.学校代码
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where c.单位号 not like 'fsyy%' and c.任职状态='在职' and b.是否实验技术人员='否'
    and not exists(select 1 from 校领导基本信息 e where b.工号=e.工号)
    and not exists(select 1 from 相关管理人员基本信息 f where b.工号=f.工号)
    and not exists(select 1 from 学校单位信息 d where d.单位号=c.单位号 and d.单位职能 is not null)
    and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页师资情况博硕覆盖率对标2016
===
    select a.学校名称,
    count(distinct case when c.最高学位 in('博士','硕士') then b.工号 else null end)/count(distinct b.工号)*100 学校值
    from 在编教职工 b
    left join 教职工基本信息 c on b.工号=c.工号 and b.学校代码=c.学校代码
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where c.单位号 not like 'fsyy%' and c.任职状态='在职' and b.是否实验技术人员='否'
    and not exists(select 1 from 校领导基本信息 e where b.工号=e.工号)
    and not exists(select 1 from 相关管理人员基本信息 f where b.工号=f.工号)
    and not exists(select 1 from 学校单位信息 d where d.单位号=c.单位号 and d.单位职能 is not null)
    and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页师资情况生师比对标2016
===
    select a.学校名称,a.折合学生数/(b.专任教师数+c.其他教师总数) 学校值 from (
      select a.学校名称,
      sum(b.普通本科学生数+b.普通高职学生数+b.硕士研究生数全日制*1.5+b.博士研究生数全日制*2+b.留学生数*3+b.普通预科生数+b.进修生数+b.成人脱产学生数+b.夜大学生数*0.3+b.函授学生数*0.1) 折合学生数
      from 学生数量基本情况 b
      left join 学校基本信息 a on a.学校代码=b.学校代码
      where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
      group by a.学校代码
    ) a left join (
      select a.学校名称,count(distinct b.工号) 专任教师数
      from 在编教职工 b
      left join 教职工基本信息 c on b.工号=c.工号 and b.学校代码=c.学校代码
      left join 学校基本信息 a on a.学校代码=b.学校代码
      where c.单位号 not like 'fsyy%' and c.任职状态='在职' and b.是否实验技术人员='否'
      and not exists(select 1 from 校领导基本信息 e where b.工号=e.工号)
      and not exists(select 1 from 相关管理人员基本信息 f where b.工号=f.工号)
      and not exists(select 1 from 学校单位信息 d where d.单位号=c.单位号 and d.单位职能 is not null)
      and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
      group by a.学校代码
    ) b on a.学校名称=b.学校名称 left join (
      select y.学校名称,sum(y.直属医院具有医师职称的医生数*0.15+y.一般外聘教师数*0.5+y.外聘的非直属医院的教师数*0.5*0.15) 其他教师总数
      from (
        select a.学校名称,a.学校代码,count(distinct case when b.聘期=-1 and not exists(select 1 from 学校单位信息 d where d.单位号=b.单位号 and d.单位职能 is not null) and b.单位号 like 'fsyy%' then b.工号 else null end) 直属医院具有医师职称的医生数,
        count(distinct case when b.聘期>=6 and b.单位号 not like 'fsyy%' then b.工号 else null end) 一般外聘教师数,
        count(distinct case when b.聘期>=6 and b.单位号 like 'fsyy%' then b.工号 else null end) 外聘的非直属医院的教师数
        from 教职工基本信息 b
        left join 学校基本信息 a on a.学校代码=b.学校代码
        where b.任职状态<>'当年离职' and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
        group by a.学校代码
      ) y group by y.学校代码
    ) c on a.学校名称=c.学校名称 order by 学校值 desc

首页师资情况专任教师对标2017
===
    select a.学校名称,count(distinct b.工号) 学校值
    from 在编教职工 b
    left join 教职工基本信息 c on b.工号=c.工号 and c.学校代码=b.学校代码
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.任教类型<>'无任教' and b.是否实验技术人员='否'
    and c.任职状态='在职'
    and not exists(select 1 from 校领导基本信息 c where c.工号=b.工号 and c.学校代码=b.学校代码)
    and not exists(select 1 from 相关管理人员基本信息 d where d.学校代码=b.学校代码 and d.工号=b.工号 and d.职务 like '%辅导员%')
    and not exists(select 1 from 学校单位信息 d where d.学校代码=b.学校代码 and d.单位号=c.单位号 and d.单位类别='党政单位')
    and b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by b.学校代码 order by 学校值 desc

首页师资情况博硕覆盖率对标2017
===
    select a.学校名称,
    count(distinct case when c.最高学位 in('博士','硕士') then b.工号 else null end)/count(distinct b.工号)*100 学校值
    from 在编教职工 b
    left join 教职工基本信息 c on b.工号=c.工号 and c.学校代码=b.学校代码
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.任教类型<>'无任教' and b.是否实验技术人员='否'
    and c.任职状态='在职'
    and not exists(select 1 from 校领导基本信息 c where c.工号=b.工号 and c.学校代码=b.学校代码)
    and not exists(select 1 from 相关管理人员基本信息 d where d.学校代码=b.学校代码 and d.工号=b.工号 and d.职务 like '%辅导员%')
    and not exists(select 1 from 学校单位信息 d where d.学校代码=b.学校代码 and d.单位号=c.单位号 and d.单位类别='党政单位')
    and b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by b.学校代码 order by 学校值 desc

首页师资情况生师比对标2017
===
    select a.学校名称,a.折合学生数/(b.专任教师数+c.其他教师总数) 学校值 from (
      select a.学校名称,
      sum(b.普通本科学生数+b.普通高职学生数+b.硕士研究生数全日制*1.5+b.博士研究生数全日制*2+b.留学生数*3+b.普通预科生数+b.进修生数+b.成人脱产学生数+b.夜大学生数*0.3+b.函授学生数*0.1) 折合学生数
      from 学生数量基本情况 b
      left join 学校基本信息 a on a.学校代码=b.学校代码
      where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
      group by a.学校代码
    ) a left join (
      select a.学校名称,count(distinct b.工号) 专任教师数
      from 在编教职工 b
      left join 教职工基本信息 c on b.工号=c.工号 and c.学校代码=b.学校代码
      left join 学校基本信息 a on a.学校代码=b.学校代码
      where b.任教类型<>'无任教' and b.是否实验技术人员='否'
      and c.任职状态='在职'
      and not exists(select 1 from 校领导基本信息 c where c.工号=b.工号 and c.学校代码=b.学校代码)
      and not exists(select 1 from 相关管理人员基本信息 d where d.学校代码=b.学校代码 and d.工号=b.工号 and d.职务 like '%辅导员%')
      and not exists(select 1 from 学校单位信息 d where d.学校代码=b.学校代码 and d.单位号=c.单位号 and d.单位类别='党政单位')
      and b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) group by b.学校代码
    ) b on a.学校名称=b.学校名称 left join (
      select y.学校名称,sum(y.直属医院具有医师职称的医生数*0.15+y.一般外聘教师数*0.5+y.非直属医院的教师数*0.5*0.15) 其他教师总数
      from (
        select b.学校名称,b.学校代码,
        count(distinct case when a.聘期=-2 and exists(select 1 from 学校单位信息 b where b.单位号=a.单位号 and b.单位类别='教学单位' and b.单位职能='直属附属医院') then a.工号 else null end) 直属医院具有医师职称的医生数,
        count(distinct case when a.聘期=-2 and exists (select 1 from 学校单位信息 b where b.单位号=a.单位号 and b.单位类别='教学单位' and b.单位职能='非直属附属医院') then a.工号 else null end) 非直属医院的教师数,
        count(distinct case when a.聘期>=6 then a.工号 else null end) 一般外聘教师数
        from 教职工基本信息 a
        left join 学校基本信息 b on a.学校代码=b.学校代码
        where a.任职状态<>'当年离职' and b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
        group by b.学校代码
      ) y group by y.学校代码
    ) c on a.学校名称=c.学校名称 order by 学校值 desc