# Breve explicação da arquitetura do projeto.
<ul>
  <li>
    Há 2 tipos de gerenciadores de processo, um genérico e um de IO bound, ambos são classes filhas de uma classe abstrata de gerenciamento de processos.
  </li>
  <li>
    Cada gerenciador operaciona a transição entre estados de um processo.
  </li>
  <li>
    Há duas constantes referentes aos tipos de gerenciados de processos.
  </li>
  <li>
    Os estados são: Ready(pronto), Running(executando), Terminated(finalizado), WaitingIO(esperando entrada e saída).
  </li>
  <li>
    Há uma lógica de estratégias de interrupção, se for um gerenciador de processo IO bound executando, ele interormpe e passa para o estado WaitingIO, caso contrário, um gerenciador genérico, ele vai para o estado Ready.
  </li>
</ul>
<br>
Main ainda não foi implementada, se acharem necessário, implemento um exemplo na main com alguma saída para mostrar nos slides.
