首页高校情况
===
    select * from (
      select count(distinct case when a.单位类别='党政单位' then a.单位号 else null end ) 党政单位,
      count(distinct case when a.单位类别='教学单位' then a.单位号 else null end ) 教学单位
      from 学校单位信息 a
    ) a,(
      select count(distinct a.重点学科名称) 重点学科数 from 重点学科 a
    ) b,(
      select a.`普通本科学生数`+ a.`普通高职学生数`+ a.`硕士研究生数全日制`+ a.`博士研究生数全日制`+
      a.`留学生数`+ a.`普通预科生数`+ a.`成人脱产学生数`+ a.`进修生数` 全日制在校生数 from 学生数量基本情况 a
    ) c,(
      select count(distinct a.工号) 教职工总数 from 教职工基本信息 a
    ) d,(
      select a.占地总面积,a.总建筑面积 from 占地与建筑面积 a
    ) e

首页教学成果2016
===
    select *,0 牵头建设国家级实践育人创新创业基地 from (
      select sum(a.教学成果奖国家级) 国家级教学成果奖 from 教学管理人员成果 a
    ) a,(
      select count(case when a.级别='国家级' then a.立项编号或批准文号 else null end) 国家级教育教学研究与改革项目
      from 教育教学研究与改革项目 a
    ) b,(
      select count(case when a.项目级别='国家级' then 1 else null end) 国家级本科教学工程,
      count(case when a.项目级别='省部级' then 1 else null end) 省部级本科教学工程 from 省级及以上本科教学工程项目情况 a
    ) c,(
      select count(case when a.类型='人才培养模式创新实验区' then 1 else null end) 人才培养模式创新实验区,
      count(case when a.类型='国家级教学基地' then 1 else null end) 国家级教学基地 from 人才培养模式创新实验项目 a
    ) d

首页教学成果2017
===
    select * from (
      select sum(a.教学成果奖国家级) 国家级教学成果奖 from 教学管理人员成果 a
    ) a,(
      select count(case when a.级别='国家级' then a.立项编号或批准文号 else null end) 国家级教育教学研究与改革项目
      from 教育教学研究与改革项目 a
    ) b,(
      select count(case when a.项目级别='国家级' then 1 else null end) 国家级本科教学工程,
      count(case when a.项目级别='省部级' then 1 else null end) 省部级本科教学工程 from 省级及以上本科教学工程项目情况 a
    ) c,(
      select count(case when a.类型='人才培养模式创新实验区' then 1 else null end) 人才培养模式创新实验区,
      count(case when a.类型='国家级教学基地' then 1 else null end) 国家级教学基地 from 人才培养模式创新实验项目 a
    ) d,(
      select count(case when a.基地级别='国家级' then 1 else null end) 牵头建设国家级实践育人创新创业基地 from 高校实践育人创新创业基地 a
    ) e

首页办学条件
===
    select * from (
      select a.学校教育经费总额 教育经费总额,a.教学经费总额 教学经费总额 from 教育经费概况 a
    ) a,(
      select a.教育经费支出总计 教学经费支出,a.实践教学支出 实践教学经费 from 教育经费收支情况 a
    ) b,(
      select a.固定资产总值 固定资产总值,a.教学科研仪器设备资产总值 教学仪器设备值 from 固定资产 a
    ) c

首页学生情况
===
    select * from (
      select b.`普通本科学生数` 本科生,b.`普通高职学生数` 专科生,
      b.`硕士研究生数` 硕士研究生,b.`博士研究生数` 博士研究生,b.`留学生数` 留学生
      from 学生数量基本情况 b
    ) a,(
      select b.`实际录取数` 招生人数 from `近一届本科生招生类别情况` b
    ) b,(
      select sum(b.`应届毕业生数`) 毕业生人数,sum(b.`应届就业人数`) 就业人数 from 应届本科毕业生分专业毕业就业情况 b
    ) c,(
      select b.`学校所在区域就业总数` 本省就业生数 from 应届本科毕业生就业情况 b
    ) d

首页师资情况2016
===
    select *,d.折合学生数/(g.专任教师数+h.其他教师总数) 生师比,g.博硕专任教师数/g.专任教师数*100 博硕覆盖率,e.上课教授数/f.教授总数*100 教授上台讲课比例 from (
      select count(1) 教职工人数 from 教职工基本信息 b
    ) a,(
      select count(case when b.是否实验技术人员='是' then 1 else null end) 实验师资 from 在编教职工 b
    ) b,(
      select count(distinct b.工号) 高层次人才总数 from 高层次人才 b
    ) c,(
      select sum(b.普通本科学生数+b.普通高职学生数+b.硕士研究生数全日制*1.5+b.博士研究生数全日制*2+b.留学生数*3+b.普通预科生数+b.进修生数+b.成人脱产学生数+b.夜大学生数*0.3+b.函授学生数*0.1) 折合学生数
      from 学生数量基本情况 b
    ) d,(
      select count(distinct b.工号) 上课教授数 from 开课情况 a
      left join 教职工基本信息 b on a.授课教师工号=b.工号
      where b.专业技术职称='教授'
    ) e,(
        select count(distinct b.工号) 教授总数 from 教职工基本信息 b where b.专业技术职称='教授'
    ) f,(
      select sum(专任教师数) 专任教师数,sum(博硕专任教师数) 博硕专任教师数
      from ( 
        select count(distinct b.工号) 专任教师数,
        count(distinct case when c.最高学位 in('博士','硕士') then b.工号 else null end) 博硕专任教师数
        from 在编教职工 b
        left join 教职工基本信息 c on b.工号=c.工号
        where c.单位号 not like 'fsyy%'
        and c.任职状态='在职' and b.是否实验技术人员='否'
        and not exists(select 1 from 校领导基本信息 e where b.工号=e.工号)
        and not exists(select 1 from 相关管理人员基本信息 f where b.工号=f.工号)
        and not exists(select 1 from 学校单位信息 d where d.单位号=c.单位号 and d.单位职能 is not null)
      ) a
    ) g,(
      select sum(直属医院具有医师职称的医生数*0.15+y.一般外聘教师数*0.5+外聘的非直属医院的教师数*0.5*0.15) 其他教师总数
      from (
        select count(distinct case when b.聘期=-1 and not exists(select 1 from 学校单位信息 d where d.单位号=b.单位号 and d.单位职能 is not null) and b.单位号 like 'fsyy%' then b.工号 else null end) 直属医院具有医师职称的医生数,
        count(distinct case when b.聘期>=6 and b.单位号 not like 'fsyy%' then b.工号 else null end) 一般外聘教师数,
        count(distinct case when b.聘期>=6 and b.单位号 like 'fsyy%' then b.工号 else null end) 外聘的非直属医院的教师数
        from 教职工基本信息 b
        where b.任职状态<>'当年离职'
      ) y
    ) h

首页师资情况2017
===
    select *,d.折合学生数/(g.专任教师数+h.其他教师总数) 生师比,g.博硕专任教师数/g.专任教师数*100 博硕覆盖率,e.上课教授数/f.教授总数*100 教授上台讲课比例 from (
      select count(1) 教职工人数 from 教职工基本信息 b
    ) a,(
      select count(case when b.是否实验技术人员='是' then 1 else null end) 实验师资 from 在编教职工 b
    ) b,(
      select count(distinct b.工号) 高层次人才总数 from 高层次人才 b
    ) c,(
      select sum(b.普通本科学生数+b.普通高职学生数+b.硕士研究生数全日制*1.5+b.博士研究生数全日制*2+b.留学生数*3+b.普通预科生数+b.进修生数+b.成人脱产学生数+b.夜大学生数*0.3+b.函授学生数*0.1) 折合学生数
      from 学生数量基本情况 b
    ) d,(
      select count(distinct b.工号) 上课教授数 from 开课情况 a
      left join 教职工基本信息 b on a.授课教师工号=b.工号
      where b.专业技术职称='教授'
    ) e,(
        select count(distinct b.工号) 教授总数 from 教职工基本信息 b where b.专业技术职称='教授'
    ) f,(
      select sum(专任教师数) 专任教师数,sum(博硕专任教师数) 博硕专任教师数
      from (
        select count(distinct b.工号) 专任教师数,
        count(distinct case when c.最高学位 in('博士','硕士') then b.工号 else null end) 博硕专任教师数
        from 在编教职工 b
        left join 教职工基本信息 c on b.工号=c.工号
        where b.任教类型<>'无任教' and b.是否实验技术人员='否'
        and c.任职状态='在职'
        and not exists(select 1 from 校领导基本信息 c where c.工号=b.工号)
        and not exists(select 1 from 相关管理人员基本信息 d where d.工号=b.工号 and d.职务 like '%辅导员%')
        and not exists(select 1 from 学校单位信息 d where d.单位号=c.单位号 and d.单位类别='党政单位')
      ) a
    ) g,(
      select sum(y.直属医院具有医师职称的医生数*0.15+y.一般外聘教师数*0.5+y.非直属医院的教师数*0.5*0.15) 其他教师总数
      from (
        select count(distinct case when a.聘期=-2 and exists(select 1 from 学校单位信息 b where b.单位号=a.单位号 and b.单位类别='教学单位' and b.单位职能='直属附属医院') then a.工号 else null end) 直属医院具有医师职称的医生数,
        count(distinct case when a.聘期=-2 and exists (select 1 from 学校单位信息 b where b.单位号=a.单位号 and b.单位类别='教学单位' and b.单位职能='非直属附属医院') then a.工号 else null end) 非直属医院的教师数,
        count(distinct case when a.聘期>=6 then a.工号 else null end) 一般外聘教师数
        from 教职工基本信息 a
        where a.任职状态<>'当年离职'
      ) y
    ) h

首页学科专业
===
    select * from (
      select 本科专业总数 from 学科建设
    ) a,(
        select count(distinct 学科代码) 重点学科数 from 重点学科
    ) b,(
      select 
      count(case when b.类型='博士学位授权一级学科点' then b.名称 else null end) 博士学位授权一级学科点,
      count(case when b.类型='博士学位授权二级学科点' then b.名称 else null end) 博士学位授权二级学科点,
      count(case when b.类型='硕士学位授权一级学科点' then b.名称 else null end) 硕士学位授权一级学科点,
      count(case when b.类型='硕士学位授权二级学科点' then b.名称 else null end) 硕士学位授权二级学科点
      from 博士点硕士点 b
    ) c,(
      select count(distinct b.博士后流动站名称) 博士后流动站 from 博士后流动站 b
    ) d

首页科研水平
===
    select * from (
      select count(distinct a.授权号) 专利著作权数 from 教师专利授权情况 a where a.获批时间=(#year#-1)
    ) a,(
      select count(distinct a.ISBN) 出版专著数 from 教师出版专著情况 a where a.出版时间=(#year#-1)
    ) b,(
      select count(distinct a.论文名称) 发表论文数 from 教师发表的论文情况 a where a.发表时间=(#year#-1)
    ) c,(
      select count(case when a.项目性质='纵向项目' then 1 else null end) 纵向项目数,
      count(case when a.项目性质='横向项目' then 1 else null end) 横向项目数,
      sum(case when a.项目性质='纵向项目' then a.项目经费国内+a.项目经费国际 else 0 end) 纵向项目经费,
      sum(case when a.项目性质='横向项目' then a.项目经费国内+a.项目经费国际 else 0 end)横向项目经费
      from 教师主持科研项目情况 a where 立项时间=(#year#-1)
    ) d