(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["about"],{f820:function(t,e,r){"use strict";r.r(e);var a=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"about"},[r("h3",[t._v("This is a test page to check book search results")]),r("p",[t._v(" Enter key word to look for results: ")]),r("br"),r("input",{directives:[{name:"model",rawName:"v-model",value:t.searchInput,expression:"searchInput"}],attrs:{placeholder:"enter key-word"},domProps:{value:t.searchInput},on:{input:function(e){e.target.composing||(t.searchInput=e.target.value)}}}),r("button",{on:{click:function(e){return t.getBookData()}}},[t._v(" Search")]),t.errorMessage?r("p",[t._v(t._s(t.errorMessage))]):t._e(),0===t.booksData.length&&!1===t.noSearch?r("p",[t._v(" No books found ")]):t._e(),r("table",{staticStyle:{width:"60%"},attrs:{border:"1",align:"center"}},[t._m(0),t._l(t.booksData,(function(e){return r("tr",[r("td",[t._v(" "+t._s(e.bookTitle))]),r("td",[t._v(" "+t._s(e.author))]),r("td",[t._v(" "+t._s(e.isbn))]),r("td",[t._v(" "+t._s(e.yearOfPublishing))]),r("td",[t._v(" "+t._s(e.numberOfPages))]),r("td",[t._v(" "+t._s(e.format))]),r("td",[t._v(" "+t._s(e.price))]),r("td",[t._v(" "+t._s(e.urlImage))]),r("td",[t._v(" "+t._s(e.storeName))]),r("td",[t._v(" "+t._s(e.urlData))])])}))],2)])},o=[function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("tr",[r("td",[t._v(" Book title")]),r("td",[t._v(" Author")]),r("td",[t._v(" ISBN")]),r("td",[t._v(" Year of publishing")]),r("td",[t._v(" No. of pages")]),r("td",[t._v(" Format")]),r("td",[t._v(" Price")]),r("td",[t._v(" Image")]),r("td",[t._v(" Store")]),r("td",[t._v(" Link ")])])}],s={data:function(){return{searchInput:"",booksData:"",errorMessage:"",notFoundMessage:"",noSearch:!0}},methods:{getBookData:function(){this.$http.get("api/booksearch/"+this.searchInput).then(t=>{console.log(t),this.booksData=t.data,this.noSearch=!1}).catch(t=>{this.errorMessage="Insert valid search parameters"})}}},n=s,c=r("2877"),i=Object(c["a"])(n,a,o,!1,null,null,null);e["default"]=i.exports}}]);
//# sourceMappingURL=about.8eedba2a.js.map