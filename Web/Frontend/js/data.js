
function getData(){
	var da = [];
	$.ajax({
		cache: false,
		async: false,
		type: 'get',
		data: {},
		url: "http://localhost:8081/getUserAll",
		success: function (data) {
			if(data.constructor == Object){
				da.push(data);
			}
			else{
				da=data;
			}
		}
	});
	console.log(da);
	return da;
}
function getDataById1(){
	var da = [];
	$.ajax({
		cache: false,
		async: false,
		type: 'get',
		data: {id:document.getElementById('id').value},
		url: "http://localhost:8081/getUser",
		success: function (data) {
			// console.log(data);
			// console.log(da);	
			
			if(data!=""){
				da.push(data);
			};
		
			// console.log(da);			
		}
	});
	
	return da;
}
function deleteData1(scope){
	// var da = [];
	console.log(scope)
	$.ajax({
		cache: false,
		async: false,
		type: 'get',
		data: {id:scope},
		url: "http://localhost:8081/delUser",
		success: function (data) {
		}
	});
}
function changeData1(formName){
	// var da = [];
	// console.log(scope)
	$.ajax({
		cache: false,
		async: false,
		type: 'get',
		data: {oldid:formName.oldid,id:formName.id,username:formName.username,des:formName.des,age:formName.age},
		url: "http://localhost:8081/changeUser",
		success: function (data) {
		}
	});
}
function addData1(formName){
	var da = [];
	// console.log(scope)
	$.ajax({
		cache: false,
		async: false,
		type: 'get',
		data: {id:formName.id,username:formName.name,des:formName.des,age:formName.age},
		url: "http://localhost:8081/addUser",
		success: function (data) {
		}
	});
}
// console.log(da);
var Main = {
	methods:{
		regetData(){
			this.tableData = getData();
		},
		deleteData(scope){
			deleteData1(scope);
			this.tableData = getData();
		},
		getDataById(){
			this.tableData = getDataById1();
		},	
		addData(){
			addData1(this.form);
			this.tableData = getData();
		},
		changeForm(scope){
			this.formc.id = scope.id;
			this.formc.oldid = scope.id;
			this.formc.username = scope.username;
			this.formc.age = scope.age;
			this.formc.des = scope.des;
		},
		changeData(){
			console.log(this.formc);
			changeData1(this.formc);
			this.tableData = getData();
		},
		resetForm(formName) {
			this.$nextTick(()=>{			
			   this.$refs['form'].resetFields();			
			})			
		},
		resetFormc(formName) {
			this.$nextTick(()=>{			
			   this.$refs['formc'].resetFields();			
			})			
		},
		resetFormn(formName) {
			this.$nextTick(()=>{			
			   this.$refs['numberValidateForm'].resetFields();			
			})			
		}
		
	},
	data() {
		return {
			input: '',
			tableData: 
				getData(),
		dialogFormVisible: false,
		dialogFormVisiblec: false,
		numberValidateForm: {
		          id: ''
		        },
        form: {
			id: '',
			name: '',
			des: '',
			age: ''
        },
		formc: {
			oldid: '',
			id: '',
			username: '',
			des: '',
			age: ''
		},
        formLabelWidth: '120px',
		}
	}
}
var Ctor = Vue.extend(Main)
new Ctor().$mount('#app')

