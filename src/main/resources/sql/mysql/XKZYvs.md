首页学科专业重点学科对标
===
    select a.学校名称,count(distinct b.学科代码) 学校值
    from 重点学科 b
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页学科专业本科专业总数对标
===
    select a.学校名称,b.本科专业总数 学校值
    from 学科建设 b
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页学科专业博士学位授权一级学科点对标
===
    select a.学校名称,
    count(case when b.类型='博士学位授权一级学科点' then b.名称 else null end) 学校值
    from 博士点硕士点 b
    left join 学校基本信息 a on b.学校代码=a.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by b.学校代码 order by 学校值 desc

首页学科专业博士学位授权二级学科点对标
===
    select a.学校名称,
    count(case when b.类型='博士学位授权二级学科点' then b.名称 else null end) 学校值
    from 博士点硕士点 b
    left join 学校基本信息 a on b.学校代码=a.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by b.学校代码 order by 学校值 desc

首页学科专业硕士学位授权一级学科点对标
===
    select a.学校名称,
    count(case when b.类型='硕士学位授权一级学科点' then b.名称 else null end) 学校值
    from 博士点硕士点 b
    left join 学校基本信息 a on b.学校代码=a.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by b.学校代码 order by 学校值 desc

首页学科专业硕士学位授权二级学科点对标
===
    select a.学校名称,
    count(case when b.类型='硕士学位授权二级学科点' then b.名称 else null end) 学校值
    from 博士点硕士点 b
    left join 学校基本信息 a on b.学校代码=a.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by b.学校代码 order by 学校值 desc

首页学科专业博士后流动站对标
===
    select a.学校名称,count(distinct b.博士后流动站名称) 学校值
    from 博士后流动站 b
    left join 学校基本信息 a on b.学校代码=a.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by b.学校代码 order by 学校值 desc