首页科研水平专利著作权数对标
===
    select b.学校名称,count(distinct a.授权号) 学校值
    from 教师专利授权情况 a
    left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.获批时间=(#year#-1) and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页科研水平出版专著数对标
===
    select b.学校名称,count(distinct a.ISBN) 学校值
    from 教师出版专著情况 a
    left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.出版时间=(#year#-1) and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页科研水平发表论文数对标
===
    select b.学校名称,count(distinct a.论文名称) 学校值
    from 教师发表的论文情况 a
    left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.发表时间=(#year#-1) and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页科研水平纵向项目数对标
===
    select b.学校名称,count(case when a.项目性质='纵向项目' then 1 else null end) 学校值
    from 教师主持科研项目情况 a
    left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.立项时间=(#year#-1) and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页科研水平横向项目数对标
===
    select b.学校名称,count(case when a.项目性质='横向项目' then 1 else null end) 学校值
    from 教师主持科研项目情况 a
    left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.立项时间=(#year#-1) and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页科研水平横向项目经费对标
===
    select b.学校名称,sum(case when a.项目性质='横向项目' then a.项目经费国内+a.项目经费国际 else 0 end) 学校值
    from 教师主持科研项目情况 a
    left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.立项时间=(#year#-1) and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc

首页科研水平纵向项目经费对标
===
    select b.学校名称,sum(case when a.项目性质='纵向项目' then a.项目经费国内+a.项目经费国际 else 0 end) 学校值
    from 教师主持科研项目情况 a
    left join 学校基本信息 b on a.学校代码=b.学校代码
    where a.立项时间=(#year#-1) and a.学校代码 in (10075,10108,10126,10403,10459,10593,10589,10657,10673,10694,10743,10749,10755,10759)
    group by a.学校代码 order by 学校值 desc