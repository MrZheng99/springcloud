function findAddress(){
	let Address = new Vue({
		el:"#address",
		data:{
			addressInfo:[],
	        province: '',
	        city: '',
	        area: ''
	    },
		methods:{
			deleteAddress:function(aid){
				if(confirm("确认删除该地址信息吗？")){
					axios.post("/zyl/address/deleteByAid",{aid:aid}).then(result=>{
						if(result.data.success){
							alert("地址删除成功!");
							axios.get("/zyl/address/findCurrent").then(result =>{
								this.addressInfo = result.data.data;
							})							
						}else{
							alert("删除地址失败，请稍后重试。。");
						}
					})
				}else{
				}
			},
			addAddress:function(){
				var province = $("#province").val();
				var city = $("#city").val();
				var area = $("#area").val();
				if(province != "请选择" && city !="请选择"){
					if(area == "请选择" || area == null){
						var cityinfo = province +"-" + city;
					}else{
						var cityinfo = province + "-" + city + "-" + area;
					}
				}else{
					alert("请选择配送地址！");
					return;
				}
	
				var details = $("#addAddressDetails").val();
				var nickName = $("#addAddressName").val();
				var tel = $("#addAddressTel").val();
				var label = $("#addAddressLabel").val();
				
				if( cityinfo == "" || details ==""  || nickName == "" || tel ==""  || label ==""){
					return;
				}
				axios.post("/zyl/address/insert",{city:cityinfo, details:details, nickName:nickName, tel:tel, label:label}).then(result=>{
					if(result.data.success){
			        		alert("插入地址成功");
							axios.get("/zyl/address/findCurrent").then(result =>{
								this.addressInfo = result.data.data;
							})
							$("#myModal").modal("hide");
			        	}else{
			        		alert("新增地址失败");
			        	}
				})
			},
			updateFlag:function(aid){
				axios.post("/zyl/address/updateFlag",{aid:aid,flag:1}).then(result=>{
					if(result.data.success){
						axios.get("/zyl/address/findCurrent").then(result =>{
							this.addressInfo = result.data.data;
						})
					}
					alert(result.data.msg);
				})
			},
			editAddress:function(aid){
				var province = $("#province" + aid).val();
				var city = $("#city" + aid).val();
				var area = $("#area" + aid).val();
				var nickName = $("#editAddressName" + aid).val();
				var details = $("#editAddressDetails" + aid).val();
				var tel = $("#editAddressTel" + aid).val();
				var label = $("#editAddressLabel" + aid).val();
				
				if(province != "请选择" && city !="请选择"){
					if(area == "请选择" || area == null){
						var cityinfo = province +"-" + city;
					}else{
						var cityinfo = province + "-" + city + "-" + area;
					}
				}else{
					alert("请选择配送地址！");
					return;
				}
				
				if(nickName == "" || details == "" || tel == "" || label == ""){
					alert("请完善地址信息后再修改");
					return;
				}
				
				axios.post("/zyl/address/update",{city:cityinfo, details:details, nickName:nickName, tel:tel, label:label,aid:aid,status:1}).then(result=>{
					if(result.data.success){
						alert("修改成功");				
						axios.get("/zyl/address/findCurrent").then(result =>{
							this.addressInfo = result.data.data;
						})
						$("#editModal" + aid).modal("hide");
					}else{
						alert("修改失败");
					}
				})
			},
			 mProvince: function(val) {
	             for (let i = 0, len = this.province.length; i < len; i++) {
	                 if (this.province[i].name == val) {
	                     this.city = this.province[i].sub;
	                     this.area = '';
	                     return;
	                 }
	             }
	         },
	         mCity: function(val) {
	             for (let i = 0, len = this.city.length; i < len; i++) {
	                 if (this.city[i].name == val) {
	                     this.area = this.city[i].sub;
	                     return;
	                 }
	             }
	         },
	         selectProvince: function(e) {
	             console.log(e.currentTarget.value);
	             let val = e.currentTarget.value;
	             this.mProvince(val);
	
	         },
	         selectCity: function(e) {
	             let val = e.currentTarget.value;
	             console.log(this.city);
	             this.mCity(val);
	         }
		},
		mounted:function(){
	        let arr = window.location.href.split("/");
			axios.get("/zyl/address/findCurrent").then(result =>{
				this.addressInfo = result.data.data;
				
			}),
	        axios.get("/zyl/front/js/city.json").then(res => {
	            this.province = res.data;
	        });
		}
	})
}

function modifyPwd(){
	let modifyPassword= new Vue({
		el:"#modifyPwd",
		data:{
			uid:'',
		},
		methods:{
			updatePwd:function(){
				
				this.uid = user.$data.uid;
				
				var opwd = hex_md5($("#pre_password").val());
				var npwd = hex_md5($("#password").val());

				axios.post("/zyl/user/updatePwd",qs.stringify({opwd:opwd, npwd:npwd,uid:this.uid})).then(result =>{
					if(result.data.success){
		        		alert("修改密码成功");
		        	}else{
		        		alert("修改密码失败");
		        	}
				})
			}
		}
	    
	})
	
}

function findOrder(){
	let order = new Vue({
		el:"#order",
		data:{
			orders:[],
			ordertails:[]
		},
		mounted:function(){
			axios.get("/zyl/order/findByUid").then(result =>{
				this.orders = result.data.data;
			});
		},
		methods:{
			viewDetails:function(oid){
				console.info(oid);
				axios.post("/zyl/orderDetails/findByOid",qs.stringify({oid:oid})).then(result =>{
					this.ordertails = result.data.data;
				})
			}
		}
	})
}