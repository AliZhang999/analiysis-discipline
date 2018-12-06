首页教学成果国家级教学成果奖对标
===
    select b.学校名称,sum(a.教学成果奖国家级) 学校值
    from 教学管理人员成果 a left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页教学成果国家级教育教学研究与改革项目对标
===
    select b.学校名称,count(case when a.级别='国家级' then a.立项编号或批准文号 else null end) 学校值
    from 教育教学研究与改革项目 a left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页教学成果国家级本科教学工程对标
===
    select b.学校名称,count(case when a.项目级别='国家级' then 1 else null end) 学校值
    from 省级及以上本科教学工程项目情况 a left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页教学成果省部级本科教学工程对标
===
    select b.学校名称,count(case when a.项目级别='省部级' then 1 else null end) 学校值
    from 省级及以上本科教学工程项目情况 a left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页教学成果人才培养模式创新实验区对标
===
    select b.学校名称,count(case when a.类型='人才培养模式创新实验区' then 1 else null end) 学校值
    from 人才培养模式创新实验项目 a left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页教学成果国家级教学基地对标
===
    select b.学校名称,count(case when a.类型='国家级教学基地' then 1 else null end) 学校值
    from 人才培养模式创新实验项目 a left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页教学成果牵头建设国家级实践育人创新创业基地对标
===
    select b.学校名称,count(case when a.基地级别='国家级' then 1 else null end) 学校值
    from 高校实践育人创新创业基地 a left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc