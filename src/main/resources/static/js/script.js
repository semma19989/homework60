'use strict';

let comment = {
	id:2,
	userId:8,// Id User coment
	postId:5, // Id publice
	text:"Great   ",
	print:function printAll() {
		console.log("Text: "+this.text);
		}
	};
let post = {
	id:1,
	title:"Japan",
	description:"I live in Japan",
	imageURL:"https://loremflickr.com/320/240",
	userId:5,
	isLiked: false,
	print:function printAll() {
		console.log("Title: "+this.title+
			"\nDescription: "+this.description+
			"\nLiked status: "+this.isLiked);
	}
};
function showSplashScreen() {
	document.getElementById("page-splash").hidden = false;
	document.body.classList.add("no-scroll");
}

function hideSplashScreen() {
	document.getElementById("page-splash").hidden = true;
	document.body.classList.remove("no-scroll");
}

function createCommentElement(comment) {
	let elem = document.createElement(`div`);
	elem.innerHTML = `<a href="#" class="muted">${comment.userId}</a>
	<p>${comment.text}</p>`;
	let att = document.createAttribute("class");
	att.value = "py-2 pl-3";
	elem.setAttributeNode(att);
	return elem;
}

let commentElement = createCommentElement(comment);

function addCommentElement(elem) {
	document.getElementById("comment").appendChild(elem);
}

function createPostElement(post) {
	let elem = document.createElement(`div`);
	elem.innerHTML = `
          <!-- image block start -->
          <div>
            <img class="d-block w-100" src="${post.imageURL}" alt="Post image">
          </div>
          <!-- image block end -->
          <div class="px-4 py-3">
            <!-- post reactions block start -->
            <div class="d-flex justify-content-around">
              <span class="h1 mx-2 text-danger">
                <i class="fas fa-heart"></i>
              </span>
              <span class="h1 mx-2 muted like">
                <i class="far fa-heart"></i>
              </span>
              <span class="h1 mx-2 muted">
                <i class="far fa-comment"></i>
              </span>
              <span class="mx-auto"></span>
              <span class="h1 mx-2 muted likemark">
                <i class="far fa-Likemark"></i>
              </span>
              <span class="h1 mx-2 muted">
                <i class="fas fa-likemark"></i>
              </span>
            </div>
            <!-- post reactions block end -->
            <hr>
            <!-- post section start -->
            <div>
              <p>${post.description}</p>
              </div>
            <!-- post section end -->
            <hr>
            <!-- comments section start -->
            <div>
              <div class="py-2 pl-3">
                <a href="#" class="muted">someusername</a>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid corrupti nesciunt, obcaecati fuga natus officiis.</p>
              </div>
              <div class="py-2 pl-3">
                <a href="#" class="muted">someusername</a>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid corrupti nesciunt, obcaecati fuga natus officiis.</p>
              </div>
            </div>
            <!-- comments section end -->
          </div>`;
	let att = document.createAttribute("class");
	att.value = "card my-3";
	elem.setAttributeNode(att);
	return elem;
}

let postElement = createPostElement(post);

function addPostElement(elem) {
	document.getElementById("posts").appendChild(elem);
}
window.addEventListener('load',function () {
  let like = document.getElementsByClassName("like")[0];
  like.addEventListener('click', function () {
      if(like.classList.contains("muted")){
          like.classList.remove("muted");
          like.classList.add("text-danger");
          like.children[0].classList.remove("far");
          like.children[0].classList.add("fas");
      } else {
          like.classList.remove("text-danger");
          like.classList.add("muted");
          like.children[0].classList.remove("fas");
          like.children[0].classList.add("far");
      }
  });

  let img = document.getElementsByClassName("img")[0];
  img.addEventListener('dblclick', function (){
      if(like.classList.contains("muted")){
          like.classList.remove("muted");
          like.classList.add("text-danger");
          like.children[0].classList.remove("far");
          like.children[0].classList.add("fas");
      } else {
          like.classList.remove("text-danger");
          like.classList.add("muted");
          like.children[0].classList.remove("fas");
          like.children[0].classList.add("far");
      }
  });

  let likemark = document.getElementsByClassName("likemark");
  for (let i=0; i<likemark.length;i++) {
    likemark[i].addEventListener('click', function () {
          if (likemark[i].children[0].classList.contains("far")) {
            likemark[i].children[0].classList.remove("far");
            likemark[i].children[0].classList.add("fas");
          } else {
            likemark[i].children[0].classList.remove("fas");
            likemark[i].children[0].classList.add("far");
          }
      });
  }
});
