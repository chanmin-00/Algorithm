# [level 1] 흉부외과 또는 일반외과 의사 목록 출력하기 - 132203 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/132203) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > SELECT고르다

### 채점결과

Empty

### 제출 일자

2025년 11월 05일 17:18:29

### 문제 설명

<p>다음은 종합병원에 속한 의사 정보를 담은<code>DOCTOR</code> 테이블입니다. <code>DOCTOR</code> 테이블은 다음과 같으며 <code>DR_NAME</code>, <code>DR_ID</code>, <code>LCNS_NO</code>, <code>HIRE_YMD</code>, <code>MCDP_CD</code>, <code>TLNO</code>는 각각 의사이름, 의사ID, 면허번호, 고용일자, 진료과코드, 전화번호를 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td data-xt="ok">DR_NAME<xt-dual class="inline" xtid="b8c98f7a-69fe-42dd-8ba7-79713e5b94ec" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR_NAME</xt-content></xt-dual></td>
<td data-xt="ok">VARCHAR(20)<xt-dual class="inline" xtid="2e3bcc4a-dd49-4b3b-9869-6556b4788e7b" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">바르차르(20)</xt-content></xt-dual></td>
<td data-xt="ok">FALSE<xt-dual class="inline" xtid="886be2fe-5209-4a2d-abaf-fbc7acf3a325" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">FALSE</xt-content></xt-dual></td>
</tr>
<tr>
<td data-xt="ok">DR_ID<xt-dual class="inline" xtid="1cdc761c-4a2a-4e83-9608-8a632acc005e" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR_ID</xt-content></xt-dual></td>
<td data-xt="ok">VARCHAR(10)<xt-dual class="inline" xtid="04beef1e-45af-4495-9ad6-d0093455a27d" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">VARCHAR(10)</xt-content></xt-dual></td>
<td data-xt="ok">FALSE<xt-dual class="inline" xtid="57ed1184-4822-44b3-822e-326db6b5bbb0" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">FALSE</xt-content></xt-dual></td>
</tr>
<tr>
<td data-xt="ok">LCNS_NO<xt-dual class="inline" xtid="b4aba920-5ec7-4923-8953-0c264882a136" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LCNS_NO</xt-content></xt-dual></td>
<td data-xt="ok">VARCHAR(30)<xt-dual class="inline" xtid="f0d564e9-7e6b-4adc-a401-19bd64a17c5e" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">VARCHAR(30)</xt-content></xt-dual></td>
<td data-xt="ok">FALSE<xt-dual class="inline" xtid="00254bc2-093f-4fc9-800a-8617fa0c02e8" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">FALSE</xt-content></xt-dual></td>
</tr>
<tr>
<td data-xt="ok">HIRE_YMD<xt-dual class="inline" xtid="5442f3f2-ba09-4b7d-abbb-475933812131" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">HIRE_YMD</xt-content></xt-dual></td>
<td data-xt="ok">DATE<xt-dual class="inline" xtid="7f183e8a-ddc1-467a-a926-3da8d0446047" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DATE</xt-content></xt-dual></td>
<td data-xt="ok">FALSE<xt-dual class="inline" xtid="6d3d886b-0b41-4e26-a48d-f19a90f53578" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">FALSE</xt-content></xt-dual></td>
</tr>
<tr>
<td data-xt="ok">MCDP_CD<xt-dual class="inline" xtid="270e1a09-8e50-4e22-9e42-2c6e6759e665" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">MCDP_CD</xt-content></xt-dual></td>
<td data-xt="ok">VARCHAR(6)<xt-dual class="inline" xtid="f1bcc851-def4-44d7-9c9e-43b139b68381" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">바르차르(6)</xt-content></xt-dual></td>
<td data-xt="ok">TRUE<xt-dual class="inline" xtid="4e832cc5-cc92-4407-91a2-63fb9d2ed94e" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">참</xt-content></xt-dual></td>
</tr>
<tr>
<td data-xt="ok">TLNO<xt-dual class="inline" xtid="fdda0a34-5638-4986-9174-42370b34db51" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">TLNO</xt-content></xt-dual></td>
<td data-xt="ok">VARCHAR(50)<xt-dual class="inline" xtid="00060952-ae75-4887-90e5-419ad9d7087f" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">바르차르(50)</xt-content></xt-dual></td>
<td data-xt="ok">TRUE<xt-dual class="inline" xtid="2e1774f9-5ffa-4eac-9db9-46ba434b60bb" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">참</xt-content></xt-dual></td>
</tr>
</tbody>
      </table>
<hr>

<h5>문제</h5>

<p><code>DOCTOR</code> 테이블에서 진료과가 흉부외과(CS)이거나 일반외과(GS)인 의사의 이름, 의사ID, 진료과, 고용일자를 조회하는 SQL문을 작성해주세요. 이때 결과는 고용일자를 기준으로 내림차순 정렬하고, 고용일자가 같다면 이름을 기준으로 오름차순 정렬해주세요.</p>

<hr>

<h5>예시</h5>

<p><code>DOCTOR</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th>DR_NAME</th>
<th>DR_ID</th>
<th>LCNS_NO</th>
<th>HIRE_YMD</th>
<th>MCDP_CD</th>
<th>TLNO</th>
</tr>
</thead>
        <tbody><tr>
<td>루피</td>
<td data-xt="ok">DR20090029<xt-dual class="inline" xtid="729beecc-679d-4ee3-bd42-940e9e273268" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20090029</xt-content></xt-dual></td>
<td data-xt="ok">LC00010001<xt-dual class="inline" xtid="ef12f11c-3bb7-4488-93ff-1e50daaf178a" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00010001</xt-content></xt-dual></td>
<td data-xt="ok">2009-03-01<xt-dual class="inline" xtid="91731866-82da-484d-ba42-b7460f3a6169" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2009-03-01</xt-content></xt-dual></td>
<td data-xt="ok">CS<xt-dual class="inline" xtid="cc46dc73-4dba-414b-9994-4f526611eaea" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">CS</xt-content></xt-dual></td>
<td>01085482011</td>
</tr>
<tr>
<td>패티</td>
<td data-xt="ok">DR20090001<xt-dual class="inline" xtid="86211914-88b6-4236-8c2e-82ab4d2f85d3" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20090001</xt-content></xt-dual></td>
<td data-xt="ok">LC00010901<xt-dual class="inline" xtid="3f0c0d37-a3de-46d9-80c8-5ee33829f1fa" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00010901</xt-content></xt-dual></td>
<td data-xt="ok">2009-07-01<xt-dual class="inline" xtid="080110ad-374d-4323-9940-00196acebfa2" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2009-07-01</xt-content></xt-dual></td>
<td data-xt="ok">CS<xt-dual class="inline" xtid="7e7954c1-e464-4741-a74a-ff4930383f48" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">CS</xt-content></xt-dual></td>
<td>01085220122</td>
</tr>
<tr>
<td>뽀로로</td>
<td data-xt="ok">DR20170123<xt-dual class="inline" xtid="c2a09f41-1c1d-4dc6-96d0-2af34c6f3aaa" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20170123</xt-content></xt-dual></td>
<td data-xt="ok">LC00091201<xt-dual class="inline" xtid="134025c5-b87f-4f32-b170-25120ad47cf0" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00091201</xt-content></xt-dual></td>
<td data-xt="ok">2017-03-01<xt-dual class="inline" xtid="f14cd434-12e2-4764-8427-1336dc265b5e" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2017-03-01</xt-content></xt-dual></td>
<td data-xt="ok">GS<xt-dual class="inline" xtid="5a366feb-17de-499c-a8cf-0c94d1e1e291" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">GS</xt-content></xt-dual></td>
<td>01034969210</td>
</tr>
<tr>
<td>티거</td>
<td data-xt="ok">DR20100011<xt-dual class="inline" xtid="7fbf31b4-50b6-4e7c-8ac7-e743946dd853" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20100011</xt-content></xt-dual></td>
<td data-xt="ok">LC00011201<xt-dual class="inline" xtid="a71286bc-070b-430a-b748-4405ac918f11" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00011201</xt-content></xt-dual></td>
<td data-xt="ok">2010-03-01<xt-dual class="inline" xtid="86c7b672-bbd5-4707-872d-8cf57e75fa41" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2010-03-01</xt-content></xt-dual></td>
<td data-xt="ok">NP<xt-dual class="inline" xtid="2062433c-dd51-4878-8b9c-db00f608f12a" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">NP</xt-content></xt-dual></td>
<td>01034229818</td>
</tr>
<tr>
<td>품바</td>
<td data-xt="ok">DR20090231<xt-dual class="inline" xtid="9a142e22-5645-46b5-b21d-7a5a3b6e992e" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20090231</xt-content></xt-dual></td>
<td data-xt="ok">LC00011302<xt-dual class="inline" xtid="ffcd8f2c-0a1d-43d1-8789-7ea876ec963e" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00011302</xt-content></xt-dual></td>
<td data-xt="ok">2015-11-01<xt-dual class="inline" xtid="4b91f946-327c-447b-9c5d-cd077540c4d6" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2015-11-01</xt-content></xt-dual></td>
<td data-xt="ok">OS<xt-dual class="inline" xtid="da4c0532-8404-473b-a731-fb449f11b325" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">OS</xt-content></xt-dual></td>
<td>01049840278</td>
</tr>
<tr>
<td>티몬</td>
<td data-xt="ok">DR20090112<xt-dual class="inline" xtid="83a27b31-f2e4-4158-8b43-2a120ffe0bc0" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20090112</xt-content></xt-dual></td>
<td data-xt="ok">LC00011162<xt-dual class="inline" xtid="0ac8e797-a88c-4126-8053-13e4947b3972" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00011162</xt-content></xt-dual></td>
<td data-xt="ok">2010-03-01<xt-dual class="inline" xtid="50b1fb9c-9d14-49e7-a21a-8086c09cda55" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2010-03-01</xt-content></xt-dual></td>
<td data-xt="ok">FM<xt-dual class="inline" xtid="35362b35-aef8-42a6-a410-e0e7c571e9bf" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">FM</xt-content></xt-dual></td>
<td>01094622190</td>
</tr>
<tr>
<td>니모</td>
<td data-xt="ok">DR20200012<xt-dual class="inline" xtid="e9c1b73b-af07-4502-adda-53e6eecd435d" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20200012</xt-content></xt-dual></td>
<td data-xt="ok">LC00911162<xt-dual class="inline" xtid="316fa96d-3b9c-4c5f-8135-e587b826937e" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00911162</xt-content></xt-dual></td>
<td data-xt="ok">2020-03-01<xt-dual class="inline" xtid="962754f2-8ba8-4495-a09c-4dd36dbc7327" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2020-03-01</xt-content></xt-dual></td>
<td data-xt="ok">CS<xt-dual class="inline" xtid="a10214e3-c912-46ce-9db8-452fe3ad664b" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">CS</xt-content></xt-dual></td>
<td>01089483921</td>
</tr>
<tr>
<td>오로라</td>
<td data-xt="ok">DR20100031<xt-dual class="inline" xtid="e838cecb-f7d0-4c64-b85b-7563958f9ec2" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20100031</xt-content></xt-dual></td>
<td data-xt="ok">LC00010327<xt-dual class="inline" xtid="fb8b4ad0-b3cc-4f33-80ad-9e53744a888d" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00010327</xt-content></xt-dual></td>
<td data-xt="ok">2010-11-01<xt-dual class="inline" xtid="dc85cc1d-fb64-491a-be10-d96f12ad9df7" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2010-11-01</xt-content></xt-dual></td>
<td data-xt="ok">OS<xt-dual class="inline" xtid="cadeab0e-59b3-40b8-a340-bf4a0ea6a9f0" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">OS</xt-content></xt-dual></td>
<td>01098428957</td>
</tr>
<tr>
<td>자스민</td>
<td data-xt="ok">DR20100032<xt-dual class="inline" xtid="e222af74-ce95-4a92-96ba-47912449c298" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20100032</xt-content></xt-dual></td>
<td data-xt="ok">LC00010192<xt-dual class="inline" xtid="fe5fbf0f-6597-4dea-9b20-5931f7b09fb3" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00010192</xt-content></xt-dual></td>
<td data-xt="ok">2010-03-01<xt-dual class="inline" xtid="082980da-3e91-45e1-b7ec-8e80d229166d" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2010-03-01</xt-content></xt-dual></td>
<td data-xt="ok">GS<xt-dual class="inline" xtid="396afe27-3e0f-4a00-b773-443c7a167c0d" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">GS</xt-content></xt-dual></td>
<td>01023981922</td>
</tr>
<tr>
<td data-xt="ok">벨<xt-dual class="inline" xtid="5c92ff6f-0c63-4002-bdd6-4f915ea3c7ff" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">벨</xt-content></xt-dual></td>
<td data-xt="ok">DR20100039<xt-dual class="inline" xtid="c48131bd-01db-4164-bea9-0fd12097ab8d" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20100039</xt-content></xt-dual></td>
<td data-xt="ok">LC00010562<xt-dual class="inline" xtid="31df387d-6217-4310-8475-2249e58dbf29" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">LC00010562</xt-content></xt-dual></td>
<td data-xt="ok">2010-07-01<xt-dual class="inline" xtid="ca43b24c-2f61-43bb-a672-4aef8b5ebd34" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2010-07-01</xt-content></xt-dual></td>
<td data-xt="ok">GS<xt-dual class="inline" xtid="aae9f165-cdd8-4f8a-b12e-94e6cbfde536" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">GS</xt-content></xt-dual></td>
<td>01058390758</td>
</tr>
</tbody>
      </table>
<p>SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th>DR_NAME</th>
<th>DR_ID</th>
<th>MCDP_CD</th>
<th>HIRE_YMD</th>
</tr>
</thead>
        <tbody><tr>
<td>니모</td>
<td data-xt="ok">DR20200012<xt-dual class="inline" xtid="10a9b81d-7b28-4a8d-81e8-52a1410c2e5d" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20200012</xt-content></xt-dual></td>
<td data-xt="ok">CS<xt-dual class="inline" xtid="48704d08-da1b-4cc4-9998-7277f3b65d6c" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">CS</xt-content></xt-dual></td>
<td data-xt="ok">2020-03-01<xt-dual class="inline" xtid="cca78f6d-12f7-4efa-be3a-24879acd1d16" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2020-03-01</xt-content></xt-dual></td>
</tr>
<tr>
<td>뽀로로</td>
<td data-xt="ok">DR20170123<xt-dual class="inline" xtid="a3d44dcc-8f3f-403c-b9cc-91fe23f56a11" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20170123</xt-content></xt-dual></td>
<td data-xt="ok">GS<xt-dual class="inline" xtid="48f0a01d-b506-4115-9b75-3211a6db5767" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">지에스</xt-content></xt-dual></td>
<td data-xt="ok">2017-03-01<xt-dual class="inline" xtid="cc4d85ee-2b2a-42eb-b747-aebb43889d38" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2017-03-01</xt-content></xt-dual></td>
</tr>
<tr>
<td data-xt="ok">벨<xt-dual class="inline" xtid="47c7218d-e15d-42c3-bc1e-57d1732e758e" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">벨</xt-content></xt-dual></td>
<td data-xt="ok">DR20100039<xt-dual class="inline" xtid="5a0eb014-2412-46c7-9439-d2c9173ed5f6" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20100039</xt-content></xt-dual></td>
<td data-xt="ok">GS<xt-dual class="inline" xtid="860b68fd-a313-45f9-ad1d-f1a71cce1151" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">지에스</xt-content></xt-dual></td>
<td data-xt="ok">2010-07-01<xt-dual class="inline" xtid="f12cb9d0-f189-4463-b5cb-59e5de4ce723" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2010-07-01</xt-content></xt-dual></td>
</tr>
<tr>
<td>자스민</td>
<td data-xt="ok">DR20100032<xt-dual class="inline" xtid="b5886f65-a4b3-49d7-8cdc-8d81919aff9c" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20100032</xt-content></xt-dual></td>
<td data-xt="ok">GS<xt-dual class="inline" xtid="74929b32-99cd-419e-96aa-67bf1d7caa82" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">지에스</xt-content></xt-dual></td>
<td data-xt="ok">2010-03-01<xt-dual class="inline" xtid="caec4974-33fb-4ed6-abf4-a6ff183725ab" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2010-03-01</xt-content></xt-dual></td>
</tr>
<tr>
<td>패티</td>
<td data-xt="ok">DR20090001<xt-dual class="inline" xtid="54a5c86c-c613-4520-b0a3-73560e2d5d83" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20090001</xt-content></xt-dual></td>
<td data-xt="ok">CS<xt-dual class="inline" xtid="038554e5-7063-4a31-be69-5a39029fd1ad" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">CS</xt-content></xt-dual></td>
<td data-xt="ok">2009-07-01<xt-dual class="inline" xtid="49355be7-8e79-4cb6-8788-823fa06774be" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2009-07-01</xt-content></xt-dual></td>
</tr>
<tr>
<td>루피</td>
<td data-xt="ok">DR20090029<xt-dual class="inline" xtid="8770099e-21bd-4148-827e-38743c874253" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">DR20090029</xt-content></xt-dual></td>
<td data-xt="ok">CS<xt-dual class="inline" xtid="b4582604-9005-4062-bf6c-9c371455b6dd" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">CS</xt-content></xt-dual></td>
<td data-xt="ok">2009-03-01<xt-dual class="inline" xtid="e28e11eb-e9a0-4ca3-a258-43968309f627" data-xt="ok"><xt-content class="alpha" style="opacity: 0.8;">2009-03-01</xt-content></xt-dual></td>
</tr>
</tbody>
      </table>
<hr>

<h5>주의사항</h5>

<p>날짜 포맷은 예시와 동일하게 나와야합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges