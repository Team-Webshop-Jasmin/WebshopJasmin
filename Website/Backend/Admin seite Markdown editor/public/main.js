const textEditor = document.querySelector(".text-editor");
const preview = document.querySelector(".preview");
const converter = new showdown.Converter();

textEditor.addEventListener("keyup", evt => {
  const { value } = evt.target;

  window.localStorage.setItem('markdown', value); 

  const html = converter.makeHtml(value);

  preview.innerHTML = html;
});




