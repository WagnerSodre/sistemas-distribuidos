/* Arquivo server.c: um servidor RPC simples */
#include <stdio.h>
#include "addsub.h"

/* implementação da função add */
int * add_1_svc (operands *argp, struct svc_req *rqstp)
{
   static int result;

   printf ("Recebi chamado: add %d %d\n", argp->x, argp->y);
   result = argp->x + argp->y;
   return (&result);
}

/* implementação da função sub */
int * sub_1_svc (operands *argp, struct svc_req *rqstp)
{
   static int result;

   printf ("Recebi chamado: sub %d %d\n", argp->x, argp->y);
   result = argp->x - argp->y;
   return (&result);
}

/* implementação da função mtp */
int * mtp_1_svc (operands *argp, struct svc_req *rqstp)
{
   static int result;

   printf ("Recebi chamado: mtp %d %d\n", argp->x, argp->y);
   result = argp->x * argp->y;
   return (&result);
}

/* implementação da função dvs */
int * dvs_1_svc (operands *argp, struct svc_req *rqstp)
{
   static int result;

   printf ("Recebi chamado: dvs %d %d\n", argp->x, argp->y);
   result = argp->x / argp->y;
   return (&result);
}

/* implementação da função mod */
int * mod_1_svc (operands *argp, struct svc_req *rqstp)
{
   static int result;

   printf ("Recebi chamado: mod %d %d\n", argp->x, argp->y);
   result = argp->x % argp->y;
   return (&result);
}
