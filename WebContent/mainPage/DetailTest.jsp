<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<% 
	String path = request.getContextPath();
	request.getSession().setAttribute("path", path);
%> 
	<link type="text/css" rel="stylesheet" href="${path }/css/custom.css">
	<script type="text/javascript">
	</script>
</head>
<body>

<link rel="stylesheet" href="//www.thebanchan.co.kr/fo/css/gds.css" type="text/css">
<!-- CONTENT -->
<div id="content" class="content">
	<!-- WRAP -->
	<div class="wrap gds" id="goodsInfoDiv">
	<!-- NAVI -->
<script type="text/javascript">
	$(function(){
		$(".location_slt button").each(function(){
			var list =  $(this).parent().find("ul li");
			var value = "";
			list.each(function(){
				if( $(this).data("selected")=="selected"){
					value = $(this);
				} 
			});
			if(value !== ""){
				$(this).text( value.text() );
			}
		});
	});
</script>
	<!-- //NAVI -->
		<div id="detailBaseInfo" style="display:none;">
			<input type="hidden" id="goods_no" name="goods_no" value="1808011706"/>
			<input type="hidden" id="vir_vend_no" name="vir_vend_no" value="VV17002724"/>
			<input type="hidden" id="multi_item_yn" name="multi_item_yn" value="N"/>
			<input type="hidden" id="goods_cmps_divi_cd" name="goods_cmps_divi_cd" value="20"/>
		 	<input type="hidden" id="item_no" name="item_no" value="00000"/>
			<input type="hidden" id="gift_goods_info" name="gift_goods_info" value=""/>
			<input type="hidden" id="min_qty" name="min_qty" value="1"/>
			<input type="hidden" id="nplus_base_cnt" name="nplus_base_cnt" value="0"/>
			<input type="hidden" id="nplus_cnt" name="nplus_cnt" value="0"/>
			<input type="hidden" id="sale_unit_qty" name="sale_unit_qty" value="0"/>
	
			<input type="hidden" id="poss_buy_min_price" name="poss_buy_min_price" value="10000"/>
	
			<input type="hidden" id="multi_price_yn" name="multi_price_yn" value="N"/>
			<input type="hidden" id="cart_grp_cd" name="cart_grp_cd" value="10"/>
			<input type="hidden" id="stock_qty_disp_yn" name="stock_qty_disp_yn" value="N"/>
			
			<input type="hidden" id="conts_dist_no" name="conts_dist_no" value=""/>
			<input type="hidden" id="sale_area_no" name="sale_area_no" value="D1706000844"/>
			<input type="hidden" id="sale_shop_no" name="sale_shop_no" value="1704002233"/>
			<input type="hidden" id="sale_shop_divi_cd" name="sale_shop_divi_cd" value="10"/>
	
			<input type="hidden" id="add_ord_sel_info" name="add_ord_sel_info" value=""/>
	
		</div>

		<!-- GOODS VIEW -->
		<div class="gds_view" id="gds_view">

			<!-- GOODS IMG. -->
			<div class="gds_img" id="gds_img">

				<div class="g_sell"><span class="sell"><em>이벤트<br/>특가</em></span></div>

		<div class="g_sell"><span class="sell"><em>NEW</em></span></div>
			

				<div class="gd_img_bx">

					 <div class="fade_slide gd_img" >
						<ul class="cont">
						
							<li class="active" style="background-image:url('//image.thebanchan.co.kr/upload/C00001/goods/prd/510/046/180817000022046.jpg')"><span class="ir">버터치킨커리&난 세트 이미지1</span></li>


						</ul>		
					</div>
					
					<div class="indi">
						<ul class="page">
						
							<li class="on"><a href="#gd_img_bx"><img src="//image.thebanchan.co.kr/upload/C00001/goods/prd/100/046/180817000022046.jpg" width="100" height="100" alt="버터치킨커리&난 세트" onerror="this.src='/common/images/common/noimg_100.jpg'"/><em class="ir">버터치킨커리&난 세트 이미지1 보기</em></a></li>

						</ul>
					</div>
					<script type="text/javascript">
					$(document).ready(function(){
						fade_slide('gd_img_bx', 500, true, 'mouseover', false, false);
					})	
					</script>

				

				</div>
			</div>
			<!-- //GOODS IMG. -->

			<!-- GOODS INFO -->
			<div class="gds_info" data-price_type_cd="10">
				<!-- NAME -->
				<h2 class="gd_name">여기가 제목이구나~</h2>
				<!-- //NAME -->
				
				<!-- TAG -->
				<div class="gd_ico">

	<span class="ico4"><em>의류</em></span>
				</div>
				<!-- //TAG -->
				<!-- SCORE -->
				<div class="gd_base">
					<div class="g_sns">						
						<button type="button" class="btn_sns" id="sns_lyr_open" >공유하기<b class="ir">SNS 레이어 열기</b></button>
						<!-- TOOLTIP -->
						<div class="lyr_tip_wrap">
							<div class="lyr_tip right" id="sns_lyr">
								<a href="javascript:void(0);" onclick="fnCallSNSShare('FB');" title="페이스북에 공유 새창" class="face"><span>페이스북</span></a>
								<a href="javascript:void(0);" onclick="fnCallSNSShare('KS');" title="카카오스토리에 공유 새창" class="kakao"><span>카카오스토리</span></a>
								<a href="javascript:void(0);" onclick="fnCallSNSShare('NB');" title="네이버블로그에 공유 새창" class="nhn"><span>네이버블로그</span></a>
								<a href="javascript:void(0);" onclick="fnCallSNSShare('UC');" title="URL 복사 새창" class="url"><span>URL 복사</span></a>
								<input type="hidden" id="shorten_url" value=""/>
								<button type="button" class="cls" onclick="hideTip('sns_lyr');return false;" >SNS 공유하기 레이어 닫기</button>
							</div>
						</div>
						<!-- //TOOLTIP -->
					</div>
				</div>
				<!-- INFO. -->
				<div class="gd_info">
					<dl>
						<dt>판매가
						</dt>
						<dd class="prc">
							<span class="sale"><b>5,850</b>원</span>
						</dd>
					</dl>
					<dl>
						<dt>배송정보</dt>
						<dd class="drv">
							<span>택배 <em>08/21(화요일)</em>부터 배송 받으실 수 있습니다.</span>
						</dd>
					</dl>
					<dl>
						<dt class="dt"><label for="ord_qty">수량</label></dt>
						<dd>
							<span class="qty">
								<input type="hidden" id="sale_price" name="sale_price" value="5850"/>	
								<input type="text" name="ord_qty" id="ord_qty" value="1" class="input" maxlength="3" onkeyup="overpass.goodsDetail.fnGoods.checkKeyPressQty({min_qty:1,max_qty:0,sale_poss_qty : 999999,ord_poss_max_qty_st_cd : '10',obj:this});" title="제품수량입력"/>
								<button type="button" class="minus" onclick="overpass.goodsDetail.fnGoods.setMinus({min_qty:1, max_qty:0, sale_poss_qty : 999999, ord_poss_max_qty_st_cd : '10'});return false;"  onkeypress="this.onclick;" title="제품수량감소">감소</button>							
								<button type="button" class="plus" onclick="overpass.goodsDetail.fnGoods.setPlus({max_qty:0, sale_poss_qty : 999999, ord_poss_max_qty_st_cd : '10', nplus_base_cnt:0, nplus_cnt:0 });return false;"  onkeypress="this.onclick;" title="제품수량증가">증가</button>								
							</span>
						</dd>
					</dl>
					<div id="select_set_div" data-set_goods_type="ONE" style="display:none;">
						<div class="g_set">
							<ul>

								<li id="choiceGrp0001" data-cmps_info='{"cmps_qty":"1", "cmps_grp_seq":"0001", "goods_no":"1808011700", "vir_vend_no":"VV17002724", "item_no":"00000", "set_cmps_item_no":"1800183470"}'></li>

								<li id="choiceGrp0002" data-cmps_info='{"cmps_qty":"1", "cmps_grp_seq":"0002", "goods_no":"1808011698", "vir_vend_no":"VV17002724", "item_no":"00000", "set_cmps_item_no":"1800183471"}'></li>

							</ul>
						</div>
					</div>	

				</div>
				<!-- //INFO. -->

				<!-- AMOUNT -->
				<div class="gd_amt">
					<dl>
						<dt>총 제품금액</dt>
						<dd><b id="totalAmt">5,850</b><em>원</em></dd>
					</dl>
				</div>
				<!-- //AMOUNT -->

				<!-- BTN. -->
				<div class="gd_btns">
					<!-- TOOLTIP -->
					
					<button type="button" class="cart" id="msg_open_cart" onclick="overpass.goodsDetail.fnGoods.clickCartOrd({cart_divi_cd:'10'}); return false;" title="장바구니 상품 알림 레이어 열기"><em>장바구니</em></button>
					<!-- <button type="button" class="cart" disabled="disabled">장바구니</button>  -->
					<!-- TOOLTIP showTip('lyr_msg_cart', this); -->
					<div class="lyr_tip_wrap2" >
						<div class="lyr_tip" id="lyr_msg_cart">
							<span class="txt">선택한 제품이 장바구니에 담겼습니다.</span>
							<span class="btns">
								<a href="javascript:void(0);" onclick="hideTip('lyr_msg_cart');return false;">쇼핑계속하기</a>
								<a href="javascript:void(0);" class="bx" onclick="overpass.link('CART');">장바구니 가기</a>
							</span>
							<button class="cls" type="button" onclick="hideTip('lyr_msg_cart');return false;">장바구니 제품 알림 레이어 닫기</button>
						</div>
					</div>
					<!-- //TOOLTIP -->


					<!-- //TOOLTIP -->
					<button type="button" class="buy" onclick="overpass.goodsDetail.fnGoods.clickCartOrd({cart_divi_cd:'20'});" title="주문하기 페이지 이동"><em>바로구매</em></button>
					
				</div>
				<!-- //BTN. -->
			</div>
			<!-- //GOODS INFO -->
		</div>
		<!-- GOODS VIEW -->
		<!-- GOODS CONTENT -->
		<!-- TAB1 -->
		<div class="gds_cont" id="gds_cont1">
			<div class="gd_tabs">
				<ul>
					<li class="on"><a href="#gds_cont1">제품정보<em class="ir">선택</em></a></li>
					<li><a href="#gds_cont2">제품정보고시</a></li>
					<li><a href="#gds_cont3">고객후기 <em>(0)</em></a></li>
					<li><a href="#gds_cont4">주의사항</a></li>
				</ul>
			</div>
			<!-- SET GOODS 1:1 20170508 -->
			<div class="gd_set">
				<h3><em>구성품</em></h3>
				<div class="lst">
					<ul>
						<li>
							<a href="javascript:void(0);">								
								<span class="tit">버터치킨커리(200g)</span>
								<span class="img"><img src="//image.thebanchan.co.kr/upload/C00001/goods/prd/212/981/180813000021981.jpg" width="210" height="210" alt="버터치킨커리(200g)" onerror="this.src='/common/images/common/noimg_212.jpg'"/></span>			
							</a>
							<span class="lyr"><button type="button" class="viw" onclick="overpass.goodsDetail.fnDescLayer.loadDescCont({goods_no:'1808011706',cmps_grp_seq:'0001',set_cmps_item_no:'1800183470', set_goods_type:'ONE', success:OpenLyrFull('lyr_set_opt', this)});" title="제품자세히보기 레이어열기">자세히보기</button></span>
						</li>
					
						<li>
							<a href="javascript:void(0);">								
								<span class="tit">난(2ea)</span>
								<span class="img"><img src="//image.thebanchan.co.kr/upload/C00001/goods/prd/212/977/180813000021977.jpg" width="210" height="210" alt="난(2ea)" onerror="this.src='/common/images/common/noimg_212.jpg'"/></span>			
							</a>
							<span class="lyr"><button type="button" class="viw" onclick="overpass.goodsDetail.fnDescLayer.loadDescCont({goods_no:'1808011706',cmps_grp_seq:'0002',set_cmps_item_no:'1800183471', set_goods_type:'ONE', success:OpenLyrFull('lyr_set_opt', this)});" title="제품자세히보기 레이어열기">자세히보기</button></span>
						</li>
					</ul>
				</div>
			</div>
			<!-- DETAIL -->
			<h3 class="ir">제품 상세정보</h3>
			<div class="gd_detail">
			<p><img alt="" src="http://image.thebanchan.co.kr/upload/C00001/fckeditor/tempgoodsdesc/201808/1534467144078.jpg" /></p>
			</div>
			<!-- DETAIL -->
		</div>
		<!-- //TAB1 -->
		<!-- TAB2 -->
		<div class="gds_cont" id="gds_cont2">
			<div class="gd_tabs">
				<ul>
					<li><a href="#gds_cont1">제품정보</a></li>
					<li class="on"><a href="#gds_cont2">제품정보고시<em class="ir">선택</em></a></li>
					<li><a href="#gds_cont3">고객후기 <em>(0)</em></a></li>
					<li><a href="#gds_cont4">주의사항</a></li>
				</ul>
			</div>
			<!-- SET SORT -->
			<div class="gd_set_sort">
				<label class="ir" for="guide_goods">세트제품선택</label>
				<select id="guide_goods">
					<option value="1808011700">버터치킨커리(200g)</option>
					<option value="1808011698">난(2ea)</option>
				</select>
			</div>
			<!-- //SET SORT -->
			<script type="text/javascript">
			$(document).ready(function(){
				var setGoodsArr = {};
				$("#guide_goods").change(function(){
					$("div[id^=guide_desc]").hide();
					$("#guide_desc_"+$(this).val()).show();
				});
				setGoodsArr["guide_set0001"] = [{goods_no:"1808011700", goods_nm:"버터치킨커리(200g)"},{goods_no:"1808011698", goods_nm:"난(2ea)"}];
				fnGuideInit = function(){
					fnOptInsert("guide_set0001");
				};
				fnOptInsert = function(val){
					var optHtml = "";
					var cmpsGoodsArr= setGoodsArr[val];
					for(var i = 0 ; i < cmpsGoodsArr.length ; i++ ){
						var goodsInfo = cmpsGoodsArr[i];
						optHtml +="<option value=\""+goodsInfo.goods_no+"\">" + goodsInfo.goods_nm + "</option>";
					};
					$("#guide_goods").html(optHtml);
					$("#guide_goods").change();
				}
				fnGuideInit();
			});
			</script>
			<div class="gds_tbl" id="guide_desc_1808011698" style="display:none;">
				<h3 class="ir">제품 기본 정보</h3>
				<table>
					<caption>제픔정보고시 | 제품의 유형, 생산자 및 소재지, 유통기한 또는 품질유지기한, 내용량, 원재료명 및 함량, 보관방법 / 취급방법, 영양성분, 유전자재조합식품여부, 수입신고 필 여부, 알레르기 식품, 소비자상담 관련 전화번호 등을 제공하는 표</caption>
					<colgroup>
						<col style="width:210px">
						<col style="width:auto">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">품목제조보고번호</th>
							<td>해당사항없음</td>
						</tr>
						<tr>
							<th scope="row">특정성분</th>
							<td>해당사항없음</td>
						</tr>
						<tr>
							<th scope="row">식품의 유형</th>
							<td>빵류(가열하지 않고 섭취하는 냉동식품)</td>
						</tr>
						<tr>
							<th scope="row">생산자 및 소재지</th>
							<td>- 제조업소명: 시그니쳐 인터내셔날 푸드
 - 수입업소명: ㈜선인 / 경기도 용인시 기흥구 탑실로 35번길 20</td>
						</tr>
						<tr>
							<th scope="row">유통기한 또는 품질유지기한</th>
							<td>제조일로부터 1년
 - 제조일자: 제품에 'MFD' 일/월/년 으로 별도표기
 - 유통기한: 제품에 'BBD' 일/월/년 으로 별도표기일까지</td>
						</tr>
						<tr>
							<th scope="row">내용량</th>
							<td>160g (2매/460kcal)</td>
						</tr>
					
						<tr>
							<th scope="row">원재료명 및 함량</th>
							<td>밀가루(밀,인도산),정제수,설탕,팜쇼트닝(경화팜유),크림(우유),정제염,이스트,베이킹파우더,합성보존료(프로피온산칼슘) / [밀,우유 함유]</td>
						</tr>
					
						<tr>
							<th scope="row">섭취방법</th>
							<td>상세페이지 참고</td>
						</tr>
					
						<tr>
							<th scope="row">보관방법 / 취급방법</th>
							<td>-18℃이하 냉동보관 / 이미 냉동된 바 있으니, 해동 후 재 냉동 시키지 마시고 바로 사용 바랍니다.</td>
						</tr>
					
						<tr>
							<th scope="row">포장재질</th>
							<td>폴리프로필렌(내면)</td>
						</tr>
					
						<tr>
							<th scope="row">알레르기 식품</th>
							<td>해당사항없음</td>
						</tr>
					
						<tr>
							<th scope="row">소비자상담 관련 전화번호</th>
							<td>031-284-9500</td>
						</tr>
					
						<tr>
							<th scope="row">영양성분</th>
							<td>상세페이지 참고</td>
						</tr>
					
						<tr>
							<th scope="row">유전자재조합식품여부</th>
							<td>해당사항없음</td>
						</tr>
					
						<tr>
							<th scope="row">표시광고사전심의필 유무</th>
							<td>해당사항없음</td>
						</tr>
					
						<tr>
							<th scope="row">수입신고 필 여부</th>
							<td>식품위생법에 따른 수입신고를 필함</td>
						</tr>
						

					</tbody>
				</table>
			</div>

			<div class="gds_tbl" id="guide_desc_1808011700" style="display:none;">
				<h3 class="ir">제품 기본 정보</h3>
				<table>
					<caption>제픔정보고시 | 제품의 유형, 생산자 및 소재지, 유통기한 또는 품질유지기한, 내용량, 원재료명 및 함량, 보관방법 / 취급방법, 영양성분, 유전자재조합식품여부, 수입신고 필 여부, 알레르기 식품, 소비자상담 관련 전화번호 등을 제공하는 표</caption>
					<colgroup>
						<col style="width:210px">
						<col style="width:auto">
					</colgroup>
					<tbody>
					
						<tr>
							<th scope="row">품목제조보고번호</th>
							<td>200900864491504</td>
						</tr>
					
						<tr>
							<th scope="row">특정성분</th>
							<td>닭고기(가슴살)21.7%, 버터4.8%, 카레2.6%(카레분10.5%)</td>
						</tr>
					
						<tr>
							<th scope="row">식품의 유형</th>
							<td>즉석조리식품</td>
						</tr>
					
						<tr>
							<th scope="row">생산자 및 소재지</th>
							<td>(주)동원홈푸드 가산공장/서울특별시 금천구 서부샛길 280</td>
						</tr>
					
						<tr>
							<th scope="row">유통기한 또는 품질유지기한</th>
							<td>제조일로부터 냉장 3일</td>
						</tr>
					
						<tr>
							<th scope="row">내용량</th>
							<td>200 g</td>
						</tr>
					
						<tr>
							<th scope="row">원재료명 및 함량</th>
							<td>정제수,닭고기(가슴살)21.7%(국내산),휘핑크림{독일산/유크림,혼합제제(유단백,전분,유화제,결정셀룰로오스,셀룰로오스검)},양파(국내산),버터4.8%(뉴질랜드산),포모도리필라티,구운캐슈너트,대두유,카레2.6%[밀가루(밀:미국산/호주산),카레분10.5%{강황(인도산),코리안더(모로코산)}],칠리씨즈닝,큐민분말,천일염,고춧가루(국내산),마늘,생강,터마릭가루,후추   *우유,대두,밀,토마토,닭고기,쇠고기,조개류 함유</td>
						</tr>
					
						<tr>
							<th scope="row">섭취방법</th>
							<td>가열 후 섭취</td>
						</tr>
					
						<tr>
							<th scope="row">보관방법 / 취급방법</th>
							<td>냉장보관(0~10℃)</td>
						</tr>
					
						<tr>
							<th scope="row">포장재질</th>
							<td>PE(내면)</td>
						</tr>
					
						<tr>
							<th scope="row">알레르기 식품</th>
							<td>본 제품은 난류,메밀,땅콩,고등어,게,새우,돼지고기,복숭아,아황산류,호두,오징어를 사용한 제품과 같은 제조시설에서 제조하고 있습니다.</td>
						</tr>
					
						<tr>
							<th scope="row">소비자상담 관련 전화번호</th>
							<td>1644-6844</td>
						</tr>
					
						<tr>
							<th scope="row">영양성분</th>
							<td>해당사항없음</td>
						</tr>
					
						<tr>
							<th scope="row">유전자재조합식품여부</th>
							<td>해당사항없음</td>
						</tr>
					
						<tr>
							<th scope="row">표시광고사전심의필 유무</th>
							<td>해당사항없음</td>
						</tr>
					
						<tr>
							<th scope="row">수입신고 필 여부</th>
							<td>해당사항없음</td>
						</tr>
						

					</tbody>
				</table>
			</div>
			
		</div>
		<!-- //TAB2 -->

		<!-- TAB3 -->
		<div class="gds_cont" id="gds_cont3">
			<div class="gd_tabs">
				<ul>
					<li><a href="#gds_cont1">제품정보</a></li>
					<li><a href="#gds_cont2">제품정보고시</a></li>
					<li class="on"><a href="#gds_cont3">고객후기 <em>(0)</em><em class="ir">선택</em></a></li>
					<li><a href="#gds_cont4">주의사항</a></li>
				</ul>
			</div>
			<div class="gd_scr">
				<dl>
					<dt>사용자 총 평점<em>(총 <b>0</b>개 고객후기 기준)</em></dt>
					<dd>
						<span class="star_rate04"><b class="ir">평점</b><em style="width:0%;">0</em></span>
						<span class="scr"><b>0</b>/5<em>점</em></span>
					</dd>
				</dl>
			</div>
			<div class="gd_rv" id="goodsEvalDiv">

			</div>
		</div>
		<!-- //TAB3 -->
		<script type="text/javascript">
		$(document).ready(function(){
			var param = {
					goods_no: "1808011706",
					vir_vend_no : "VV17002724",
					goods_type_dtl_cd : "2012",
					goods_detail_yn : "Y"
				};
			
			
			overpass.goodsDetail.fnEval.fnLoadEval(param, "#goodsEvalDiv");

		});
		</script>

		<!-- TAB4 -->
		<div class="gds_cont" id="gds_cont4">
			<div class="gd_tabs">
				<ul>
					<li><a href="#gds_cont1">제품정보</a></li>
					<li><a href="#gds_cont2">제품정보고시</a></li>
					<li><a href="#gds_cont3">고객후기 <em>(0)</em></a></li>
					<li class="on"><a href="#gds_cont4">주의사항</a><em class="ir">선택</em></li>
				</ul>
			</div>
			<div class="gd_noti">
				<h3>주문 전 꼭 확인해 주세요</h3>
				<div class="g_noti bg_car">
					<ul>
						<li>최소 구매액은 10,000원(기본 포장 비용) 부터 가능합니다.</li>

						<li>결제금액 기준 <b>45,000원이상 구매시 무료배송</b>입니다.
							<span>배송비는 할인금액 적용한 결제금액 기준 45,000원 이상은 무료배송,<br/>45,000원 미만은 일반 택배는 2,500원 /수도권 새벽직배송은 2,900원이 부가 됩니다.</span> 
						</li>

						<li>주문마감 이전에 결제 완료시, 지정하신 희망배송일에 받을 수 있습니다. 
							<span>
								주문 마감 이전에 결제 완료시, 지정하신 희망배송일에 받을 수 있습니다.<br/>
								단, 월요일에는 일반 택배사 휴무 관계로 인하여 희망배송일로 지정되지 않습니다.<br/><br/>
								새벽직배송의 경우 제품수령일 당일 오전 7시까지 받으실 수 있습니다.<br/>
								(교통사항, 천재지변, 명절특수 등의 경우 변경이 있을 수 있으니 상세확인은 고객센터로 문의해 주세요)
							</span>
						</li>
					</ul>
				</div>
				<h3>취소/반품 주의사항</h3>
				<div class="g_noti">
					<ul>
						<li>주문취소는 주문마감시간 (오전6시) 전까지 취소가 가능합니다.
							<span>주문취소는 MY더반찬 &gt; 주문취소에서 직접 취소 가능합니다.</span>
						</li>
						<li>주문 직접취소가 어려울 경우
							<span>결제/입금 완료된 상태에서 직접취소가 어려우실 경우 고객센터 운영시간 (오전9시~오후6시) 연락주시기 바랍니다.<br/>비회원의 경우 동일하게 고객센터 운영시간에 연락주시면 취소가 가능합니다.</span>
						</li>
						<li>반품정책
							<span>고객의 단순변심으로 교환 및 반품이 되지 않으니 양해바랍니다.</span>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- //TAB4 -->


	</div>
	<!-- WRAP -->
	
</div>
<!-- //CONTENT -->


