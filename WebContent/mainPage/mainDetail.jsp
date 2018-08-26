<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>	
<%-- mainDetail.jsp --%>
 <link type="text/css" rel="stylesheet" href="${path }/css/custom.css"> 
<link rel="stylesheet" href="//www.thebanchan.co.kr/fo/css/gds.css" type="text/css">
<link rel="icon" href="/Funshop/image/favicon.ico">
<div id="bodyClear"></div>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"${path}/mainPage.do?action=detailType",
			data:{"detailType": "${pro.type}"},
			success:function(result){
				var typeList = result.split(",");
				$("#typeSelect").html(result);
			}
		});
		$("button.minus").click(function(){
			var minus = $("input#ord_qty").val();
			if(minus <2){
				return;
			}
			$("input#ord_qty").val(--minus);
			/* $("#totalAmt").html(
					$("input#ord_qty").val()*$("span.sale").text()	
			); */
		});
		 $("button.plus").click(function(){
			var plus = $("input#ord_qty").val();
			$("input#ord_qty").val(++plus);
			/* $("#totalAmt").html(
					$("input#ord_qty").val()*$("span.sale").text()	
			); */
		}); 
		/* $("input#ord_qty").keyup(function(){
			$("#totalAmt").html(
					$(this).val()*$("span.sale").text()	
			);
		}); */
		
		/* $("#totalAmt").html(
				$("input#ord_qty").val()*$("span.sale").text()	
		); */
		$(":button.buy").click(function(){
			location = "${path}/mainPage/buyhis.do";
			});
		$("#selectName").change(function(){
			var selectName = $(this).val();
			$("#inputSelect").attr("value", selectName);
		});
			var cnt1=0;
			var cnt2=0;
		$("#opAdd").click(function(){
			$("table#opTable").append("<tr><th id=optionH"+(cnt1++)+">"+$("#selectName").val()+"</th><td id=optionD"+(cnt2++)+">"+$("#ord_qty").val()+"</td></tr>");
			var price = $("#"+$('#selectName').val()).val();
			$("#totalAmt").text(parseInt($("#totalAmt").text())+parseInt(price)*$("#ord_qty").val());
			$("#hidTotal").val(parseInt($("#totalAmt").text())+parseInt(price)*$("#ord_qty").val());
			
			var optionName = $("#selectName").val();
			var hid_input = $("#hid_"+optionName);
			var pre_val = parseInt(hid_input.val());
			var plus_val = parseInt($("#ord_qty").val());
			hid_input.val(pre_val+plus_val);
		});
	});
</script>
<!-- CONTENT -->
<div id="content" class="content">
	<!-- WRAP -->
	<div class="wrap gds" id="goodsInfoDiv">
	<!-- NAVI -->
		<!-- ROUTE -->
		<div>
			<ul>
				<li><a href="${path}/mainPage/main.do">홈</a></li>
				<li><select id="typeSelect"><option>${pro.type }</option></select></li>
			</ul>
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
							<li class="active" style="background-image: url('${path }${pro.mainImg}');"></li>
						</ul>		
					</div>
				</div>
			</div>
			<!-- //GOODS IMG. -->

			<!-- GOODS INFO -->
			<div class="gds_info" data-price_type_cd="10">
				<!-- NAME -->
				<h2 class="gd_name">${pro.name }</h2>
				<!-- //NAME -->
				
				<!-- TAG -->
				<div class="gd_ico">

	<span class="ico4"><em>${pro.type }</em></span>
				</div>
				<!-- //TAG -->
				<!-- SCORE -->
				<div class="gd_base">
					<div class="g_sns">						
						<button type="button" class="btn_sns" id="sns_lyr_open" >공유</button>
					</div>
				</div>
				<!-- INFO. -->
				<div class="gd_info">
					<dl>
						<dt>판매가
						</dt>
						<dd class="prc">
							<span class="sale"><b>${lowPrice }</b></span>
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
								<button type="button" class="minus"  title="제품수량감소" >감소</button>							
								<button type="button" class="plus"  title="제품수량증가">증가</button>							
							</span>
							<input type="number" name="ord_qty" id="ord_qty" value="1" class="input" maxlength="3" min="1" readonly title="제품수량입력"/>
						</dd>
					</dl>
					
					<dl>
						<dt class="dt"><label for="ord_qty">옵션</label></dt>
						
						<dd>
							<div class="gd_set_sort">
								<select id="selectName" >
								<c:forEach items="${pdtailList }" var="pdtail" varStatus="stat">
									<option value="${pdtail.name }">${pdtail.name }</option>
								</c:forEach>
								</select>
								<c:forEach items="${pdtailList }" var="pdtail" varStatus="stat">
									<input type="hidden" id=${pdtail.name } value="${pdtail.price }">
								</c:forEach>
								<input type="hidden"  name="selectName" id="inputSelect" ></input>
								<button id="opAdd">옵션추가</button>
								<div id="opShow">
									<table id="opTable">
										
									</table>
								</div>
							</div>
						</dd>
					</dl>
				</div>
				<!-- //INFO. -->
				
				<!-- AMOUNT -->
				<div class="gd_amt">
					<dl>
						<dt>총 제품금액</dt>
						<dd><b id="totalAmt">0</b><em>원</em></dd>
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
								<a href="" class="bx" >장바구니 가기</a>
							</span>
							<button class="cls" type="button" onclick="hideTip('lyr_msg_cart');return false;">장바구니 제품 알림 레이어 닫기</button>
						</div>
					</div>
					<form action=" ${path}/mainPage.do">
						<c:forEach items="${pdtailList }" var="pdtail" varStatus="stat">
									<input type="hidden" name="${pdtail.name}" value="0"  id="hid_${pdtail.name}" >
						</c:forEach>
						<input type="hidden" value="directBuy" name="action">
						<input type="hidden" value="${pro.no}" name="productNumber">
						<input type="hidden" id="hidTotal" name="hidTotal">
					<button type="submit" class="buy"  title="주문하기 페이지 이동"><em>바로구매</em></button>
					</form>
				</div>
				<!-- //BTN. -->
			</div>
			<!-- //GOODS INFO -->
		</div>
		<!-- GOODS VIEW -->
		<!-- GOODS CONTENT -->
			<!-- DETAIL -->
			<h3 class="ir">제품 상세정보</h3>
			<div class="gd_detail">
			<p><img alt="" src="${path }${pro.mainImg}" /></p>
			</div>
			<small>${pro.summary }</small>
			<p>${pro.description}</p>
			
			<c:forEach items="${pdtailList }" var="pdtail" varStatus="stat">
			<div class="gd_detail">
			<p><img alt="" src="${path }${pdtail.pdImg}" /></p>
			</div>
			<small>${pdtail.summary }</small>
			<p>${pdtail.description}</p>
			</c:forEach>
		<!-- TAB4 -->
		<div class="gds_cont" id="gds_cont4">
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


