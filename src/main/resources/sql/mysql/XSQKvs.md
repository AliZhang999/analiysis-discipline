首页学生情况本科生对标
===
    select a.学校名称,b.普通本科学生数 学校值
    from 学生数量基本情况 b
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by a.学校代码 order by 学校值 desc

首页学生情况专科生对标
===
    select a.学校名称,b.普通高职学生数 学校值
    from 学生数量基本情况 b
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by a.学校代码 order by 学校值 desc

首页学生情况硕士研究生对标
===
    select a.学校名称,b.硕士研究生数 学校值
    from 学生数量基本情况 b
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by a.学校代码 order by 学校值 desc

首页学生情况博士研究生对标
===
    select a.学校名称,b.博士研究生数 学校值
    from 学生数量基本情况 b
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by a.学校代码 order by 学校值 desc

首页学生情况留学生对标
===
    select a.学校名称,b.留学生数 学校值
    from 学生数量基本情况 b
    left join 学校基本信息 a on a.学校代码=b.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by a.学校代码 order by 学校值 desc

首页学生情况实际录取数对标
===
    select a.学校名称,b.实际录取数 学校值
    from 近一届本科生招生类别情况 b 
    left join 学校基本信息 a on b.学校代码=a.学校代码 
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by a.学校代码 order by 学校值 desc

首页学生情况就业生数对标
=== 
    select a.学校名称,sum(b.`应届就业人数`) 学校值
    from 应届本科毕业生分专业毕业就业情况 b
    left join 学校基本信息 a on b.学校代码=a.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by a.学校代码 order by 学校值 desc

首页学生情况毕业生数对标
===
    select a.学校名称,sum(b.`应届毕业生数`) 学校值
    from 应届本科毕业生分专业毕业就业情况 b
    left join 学校基本信息 a on b.学校代码=a.学校代码
    where b.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759) 
    group by a.学校代码 order by 学校值 desc