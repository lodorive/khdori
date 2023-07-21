/*
 종합문제
 */

drop table kpop_song;
create table kpop_song(
kpop_song_no number primary key,
kpop_song_title varchar2(300) not null,
kpop_song_artist varchar2(300) not null,
kpop_song_album varchar2(300) not null,
kpop_song_playcount number default 0,
kpop_song_likecount number default 0,
check(kpop_song_playcount >= 0),
check(kpop_song_likecount >= 0)
);

drop sequence kpop_song_seq;
create sequence kpop_song_seq;

BEGIN
  FOR i IN 1..1000 LOOP
    INSERT INTO kpop_song (
      kpop_song_no,
      kpop_song_title,
      kpop_song_artist,
      kpop_song_album,
      kpop_song_playcount,
      kpop_song_likecount
    ) VALUES (
      kpop_song_seq.NEXTVAL,
      'Sample Title ' || i,
      'Sample Artist ' || i,
      'Sample Album ' || i,
      ROUND(DBMS_RANDOM.VALUE(10, 99999)), -- 재생 횟수 (10 이상 10만 미만)
      ROUND(DBMS_RANDOM.VALUE(10, 49999)) -- 좋아요 수 (10 이상 5만 미만)
    );
  END LOOP;
  COMMIT;
END;

select * from kpop_song;

-- (1) 좋아요를 가장 많이 받은 곡 Top 100을 출력
select * from (
	select rownum rn, TMP.* from (
		select * from kpop_song order by kpop_song_likecount desc
	)TMP
) where rn between 1 and 100;

-- (2) 재생을 가장 많이 한 곡 Top 100을 출력
select * from (
	select rownum rn, TMP.* from (
		select * from kpop_song order by kpop_song_playcount desc
	)TMP
) where rn between 1 and 100;

-- (3) 랭킹포인트를 계산하여 Top 100을 출력
select * from (
	select rownum rn, TMP.* from (
		select  KPOP.*,
		(kpop_song_playcount*0.6 + kpop_song_likecount*0.4) 랭킹포인트 from kpop_song KPOP order by 랭킹포인트 desc
	)TMP
) where rn between 1 and 100;

