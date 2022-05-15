const textEditor = document.querySelector(".text-editor");
const preview = document.querySelector(".preview");
const converter = new showdown.Converter();

textEditor.addEventListener("keyup", evt => {
  const { value } = evt.target;

  const html = converter.makeHtml(value);

  preview.innerHTML = html;
});




